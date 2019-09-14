package com.oleksandrbumbyk.testassignment.presentation.injection.module

import com.oleksandrbumbyk.testassignment.domain.Schedulers
import com.oleksandrbumbyk.testassignment.domain.interactor.UserUseCase
import com.oleksandrbumbyk.testassignment.domain.interactor.UserUseCaseImpl
import com.oleksandrbumbyk.testassignment.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
internal class DomainModule {

    @Provides
    @Singleton
    internal fun provideUserUseCase(schedulers: Schedulers, userRepository: UserRepository): UserUseCase {
        return UserUseCaseImpl(schedulers, userRepository)
    }
}
