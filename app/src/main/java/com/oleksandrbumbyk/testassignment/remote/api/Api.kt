package com.oleksandrbumbyk.testassignment.remote.api

import com.google.gson.GsonBuilder
import com.oleksandrbumbyk.testassignment.BuildConfig
import com.oleksandrbumbyk.testassignment.remote.model.UsersResponse
import io.reactivex.Observable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.reflect.Modifier
import java.util.concurrent.TimeUnit

class Api(baseUrl: String) : UsersService {

    companion object {
        private const val TIMEOUT = 10L
    }

    private val usersService: UsersService

    init {

        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = if (BuildConfig.DEBUG)
            HttpLoggingInterceptor.Level.BODY
        else
            HttpLoggingInterceptor.Level.BASIC

        val httpClient = OkHttpClient.Builder()
            .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(TIMEOUT, TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor)

        val client = httpClient.build()

        val gson = GsonBuilder()
            .excludeFieldsWithModifiers(Modifier.FINAL, Modifier.TRANSIENT, Modifier.STATIC)
            .create()

        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(client)
            .build()

        usersService = retrofit.create(UsersService::class.java)
    }

    override fun getUsers(seed: String, results: Int, page: Int): Observable<UsersResponse> =
        usersService.getUsers(seed, results, page)
}
