package com.oleksandrbumbyk.testassignment.domain.interactor

import com.oleksandrbumbyk.testassignment.domain.Schedulers
import com.oleksandrbumbyk.testassignment.domain.UseCase
import com.oleksandrbumbyk.testassignment.domain.entity.User
import com.oleksandrbumbyk.testassignment.domain.repository.UserRepository
import com.oleksandrbumbyk.testassignment.domain.util.Constants
import io.reactivex.Completable
import io.reactivex.Observable

class UserUseCaseImpl(
    schedulers: Schedulers,
    private val userRepository: UserRepository
) : UseCase(schedulers),
    UserUseCase {

    private var selectedUser = listOf<User>()

    override fun getUsers(seed: String, page: Int): Observable<List<User>> =
        userRepository.getUsers(seed, Constants.PAGE_SIZE, page)
            .compose(applySchedulers())

    override fun selectUser(user: User): Completable = Completable.fromAction { selectedUser = listOf(user) }

    override fun getSelectedUser(): Observable<List<User>> = Observable.fromCallable { selectedUser }
}
