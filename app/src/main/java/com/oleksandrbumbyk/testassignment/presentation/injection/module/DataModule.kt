package com.oleksandrbumbyk.testassignment.presentation.injection.module

import com.oleksandrbumbyk.testassignment.data.repository.UserRepositoryImpl
import com.oleksandrbumbyk.testassignment.domain.repository.UserRepository
import com.oleksandrbumbyk.testassignment.remote.UserRemoteDataSource
import com.oleksandrbumbyk.testassignment.remote.UserRemoteDataSourceImpl
import com.oleksandrbumbyk.testassignment.remote.api.Api
import com.oleksandrbumbyk.testassignment.remote.api.UsersService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
internal class DataModule {

    @Provides
    @Singleton
    internal fun provideApi(): Api = Api("https://randomuser.me/api/")

    @Provides
    @Singleton
    internal fun provideUsersService(api: Api): UsersService = api

    @Provides
    @Singleton
    internal fun provideUserRemoteDataSource(usersService: UsersService): UserRemoteDataSource {
        return UserRemoteDataSourceImpl(usersService)
    }

    @Provides
    @Singleton
    internal fun provideUserRepository(userRemoteDataSource: UserRemoteDataSource): UserRepository {
        return UserRepositoryImpl(userRemoteDataSource)
    }
}
