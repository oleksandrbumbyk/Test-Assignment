package com.oleksandrbumbyk.testassignment.data.repository

import com.oleksandrbumbyk.testassignment.domain.entity.User
import com.oleksandrbumbyk.testassignment.domain.repository.UserRepository
import com.oleksandrbumbyk.testassignment.remote.UserRemoteDataSource
import io.reactivex.Observable

class UserRepositoryImpl(private val userRemoteDataSource: UserRemoteDataSource) : UserRepository {

    override fun getUsers(seed: String, results: Int, page: Int): Observable<List<User>> =
        userRemoteDataSource.getUsers(seed, results, page)
}
