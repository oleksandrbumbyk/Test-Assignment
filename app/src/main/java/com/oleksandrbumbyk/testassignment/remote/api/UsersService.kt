package com.oleksandrbumbyk.testassignment.remote.api

import com.oleksandrbumbyk.testassignment.remote.model.UsersResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface UsersService {

    @GET("")
    fun getUsers(
        @Query("seed") seed: String,
        @Query("results") results: Int,
        @Query("page") page: Int
    ): Observable<UsersResponse>
}
