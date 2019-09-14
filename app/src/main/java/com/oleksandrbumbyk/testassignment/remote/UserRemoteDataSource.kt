package com.oleksandrbumbyk.testassignment.remote

import com.oleksandrbumbyk.testassignment.domain.entity.User
import io.reactivex.Observable

interface UserRemoteDataSource {

    fun getUsers(seed: String, results: Int, page: Int): Observable<List<User>>
}
