package com.oleksandrbumbyk.testassignment.presentation.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.oleksandrbumbyk.testassignment.R
import com.oleksandrbumbyk.testassignment.domain.entity.User
import com.oleksandrbumbyk.testassignment.domain.interactor.UserUseCase
import com.oleksandrbumbyk.testassignment.presentation.adapter.item.BaseItem
import com.oleksandrbumbyk.testassignment.presentation.util.SingleLiveData
import com.oleksandrbumbyk.testassignment.presentation.viewmodel.mapper.UserMapper
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableCompletableObserver
import io.reactivex.observers.DisposableObserver
import timber.log.Timber

class HomeViewModel(
    context: Context,
    private val userUseCase: UserUseCase,
    private val userMapper: UserMapper
) : BaseAndroidViewModel(context.applicationContext as Application) {

    val list = MutableLiveData<MutableList<BaseItem>>()
    val userSelectResult = SingleLiveData<Boolean>()

    private val seed = "abc"
    private val firstPage = 0
    private var currentPage = firstPage
    private var userDisposable: Disposable? = null
    private var isAllLoaded = false

    init {
        refresh()
    }

    fun refresh() {
        userDisposable?.dispose()
        currentPage = firstPage
        isAllLoaded = false
        makePagination()
    }

    fun loadNextPage() {
        if (userDisposable != null || isAllLoaded) return
        currentPage++
        makePagination()
    }

    fun selectUser(user: User) = addDisposable(selectUserDisposable(user))

    private fun makePagination() {
        userDisposable = addDisposable(usersDisposable(seed, currentPage))
    }

    private fun usersDisposable(seed: String, page: Int): Disposable {
        return userUseCase.getUsers(seed, page)
            .subscribeWith(object : DisposableObserver<List<User>>() {

                override fun onStart() {
                    if (currentPage == firstPage) loading.postValue(true)
                }

                override fun onNext(users: List<User>) {
                    loading.postValue(false)
                    list.postValue(userMapper.toItems(users, previouslyLoadedUsers()))
                    if (users.isEmpty()) isAllLoaded = true
                    userDisposable = null
                }

                override fun onError(e: Throwable) {
                    Timber.e(e)
                    loading.postValue(false)
                    error.postValue(context.getString(R.string.error_common_message))
                    userDisposable = null
                }

                override fun onComplete() {}
            })
    }

    private fun selectUserDisposable(user: User): Disposable {
        return userUseCase.selectUser(user)
            .subscribeWith(object : DisposableCompletableObserver() {
                override fun onComplete() {
                    userSelectResult.postValue(true)
                }

                override fun onError(e: Throwable) {
                    Timber.e(e)
                }
            })
    }

    private fun previouslyLoadedUsers(): List<BaseItem> =
        if (currentPage == firstPage) mutableListOf() else list.value ?: mutableListOf()
}
