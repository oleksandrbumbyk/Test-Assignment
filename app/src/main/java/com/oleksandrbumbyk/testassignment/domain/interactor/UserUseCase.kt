package com.oleksandrbumbyk.testassignment.domain.interactor

import com.oleksandrbumbyk.testassignment.domain.entity.User
import io.reactivex.Completable
import io.reactivex.Observable

interface UserUseCase {

    fun getUsers(seed: String, page: Int): Observable<List<User>>

    fun selectUser(user: User): Completable

    fun getSelectedUser(): Observable<List<User>>
}
