package com.oleksandrbumbyk.testassignment.remote

import com.oleksandrbumbyk.testassignment.remote.api.UsersService
import com.oleksandrbumbyk.testassignment.domain.entity.User
import io.reactivex.Observable

class UserRemoteDataSourceImpl(private val usersService: UsersService) : UserRemoteDataSource {

    override fun getUsers(seed: String, results: Int, page: Int): Observable<List<User>> =
        usersService.getUsers(seed, results, page)
            .map { it.results ?: mutableListOf() }
}
