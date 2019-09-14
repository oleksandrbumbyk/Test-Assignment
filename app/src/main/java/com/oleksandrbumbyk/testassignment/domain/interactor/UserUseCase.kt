package com.oleksandrbumbyk.testassignment.domain.interactor

import com.oleksandrbumbyk.testassignment.domain.entity.User
import io.reactivex.Observable

interface UserUseCase {

    fun getUsers(seed: String, page: Int): Observable<List<User>>
}
