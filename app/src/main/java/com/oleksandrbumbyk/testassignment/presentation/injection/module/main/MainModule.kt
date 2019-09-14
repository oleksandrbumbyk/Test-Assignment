package com.oleksandrbumbyk.testassignment.presentation.injection.module.main

import com.oleksandrbumbyk.testassignment.domain.Schedulers
import com.oleksandrbumbyk.testassignment.domain.interactor.UserUseCase
import com.oleksandrbumbyk.testassignment.domain.interactor.UserUseCaseImpl
import com.oleksandrbumbyk.testassignment.domain.repository.UserRepository
import com.oleksandrbumbyk.testassignment.presentation.injection.scope.MainScope
import dagger.Module
import dagger.Provides

@Module
internal abstract class MainModule {

    @Module
    companion object {

        @MainScope
        @Provides
        @JvmStatic
        internal fun provideUserUseCase(schedulers: Schedulers, userRepository: UserRepository): UserUseCase {
            return UserUseCaseImpl(schedulers, userRepository)
        }
    }
}
