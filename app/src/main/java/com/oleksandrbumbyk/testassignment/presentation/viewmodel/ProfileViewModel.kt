package com.oleksandrbumbyk.testassignment.presentation.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.oleksandrbumbyk.testassignment.R
import com.oleksandrbumbyk.testassignment.domain.entity.User
import com.oleksandrbumbyk.testassignment.domain.interactor.UserUseCase
import com.oleksandrbumbyk.testassignment.presentation.util.SingleLiveData
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import timber.log.Timber

class ProfileViewModel(
    context: Context,
    private val userUseCase: UserUseCase
) : BaseAndroidViewModel(context.applicationContext as Application) {

    val user = MutableLiveData<User>()
    val actionCall = SingleLiveData<String>()

    init {
        loadUser()
    }

    fun callUser() {
        user.value?.phone?.let { actionCall.value = it }
    }

    private fun loadUser() = addDisposable(userDisposable())

    private fun userDisposable(): Disposable {
        return userUseCase.getSelectedUser()
            .subscribeWith(object : DisposableObserver<List<User>>() {

                override fun onStart() {
                    loading.postValue(true)
                }

                override fun onNext(users: List<User>) {
                    loading.postValue(false)
                    if (users.isNotEmpty()) user.postValue(users[0])
                }

                override fun onError(e: Throwable) {
                    Timber.e(e)
                    loading.postValue(false)
                    error.postValue(context.getString(R.string.error_common_message))
                }

                override fun onComplete() {}
            })
    }
}
