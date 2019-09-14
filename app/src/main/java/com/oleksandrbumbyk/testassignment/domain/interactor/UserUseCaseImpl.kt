package com.oleksandrbumbyk.testassignment.domain.interactor

import com.oleksandrbumbyk.testassignment.domain.Schedulers
import com.oleksandrbumbyk.testassignment.domain.UseCase
import com.oleksandrbumbyk.testassignment.domain.entity.User
import com.oleksandrbumbyk.testassignment.domain.repository.UserRepository
import com.oleksandrbumbyk.testassignment.domain.util.Constants
import io.reactivex.Observable

class UserUseCaseImpl(
    schedulers: Schedulers,
    private val userRepository: UserRepository
) : UseCase(schedulers),
    UserUseCase {

    override fun getUsers(seed: String, page: Int): Observable<List<User>> =
        userRepository.getUsers(seed, Constants.PAGE_SIZE, page)
            .compose(applySchedulers())
}
