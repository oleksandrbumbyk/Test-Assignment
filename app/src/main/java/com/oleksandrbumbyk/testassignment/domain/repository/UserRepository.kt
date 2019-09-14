package com.oleksandrbumbyk.testassignment.domain.repository

import com.oleksandrbumbyk.testassignment.domain.entity.User
import io.reactivex.Observable

interface UserRepository {

    fun getUsers(seed: String, results: Int, page: Int): Observable<List<User>>
}
