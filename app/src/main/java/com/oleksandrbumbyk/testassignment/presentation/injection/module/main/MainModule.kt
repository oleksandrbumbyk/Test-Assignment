package com.oleksandrbumbyk.testassignment.presentation.injection.module.main

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.oleksandrbumbyk.testassignment.domain.Schedulers
import com.oleksandrbumbyk.testassignment.domain.interactor.UserUseCase
import com.oleksandrbumbyk.testassignment.domain.interactor.UserUseCaseImpl
import com.oleksandrbumbyk.testassignment.domain.repository.UserRepository
import com.oleksandrbumbyk.testassignment.presentation.injection.scope.MainScope
import com.oleksandrbumbyk.testassignment.presentation.view.HomeFragment
import com.oleksandrbumbyk.testassignment.presentation.view.ProfileFragment
import com.oleksandrbumbyk.testassignment.presentation.viewmodel.HomeViewModel
import com.oleksandrbumbyk.testassignment.presentation.viewmodel.ProfileViewModel
import com.oleksandrbumbyk.testassignment.presentation.viewmodel.mapper.UserMapper
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class MainModule {

    @ContributesAndroidInjector
    internal abstract fun contributeHomeFragment(): HomeFragment

    @ContributesAndroidInjector
    internal abstract fun contributeProfileFragment(): ProfileFragment

    @Module
    companion object {

        @MainScope
        @Provides
        @JvmStatic
        internal fun provideUserUseCase(schedulers: Schedulers, userRepository: UserRepository): UserUseCase {
            return UserUseCaseImpl(schedulers, userRepository)
        }

        @MainScope
        @Provides
        @JvmStatic
        internal fun provideViewModelFactory(context: Context, userUseCase: UserUseCase): ViewModelProvider.Factory {
            return object : ViewModelProvider.Factory {
                @Suppress("UNCHECKED_CAST")
                override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                    return when {

                        modelClass.isAssignableFrom(HomeViewModel::class.java) ->
                            HomeViewModel(context, userUseCase, UserMapper()) as T

                        modelClass.isAssignableFrom(ProfileViewModel::class.java) ->
                            ProfileViewModel(context, userUseCase) as T

                        else -> throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
                    }
                }
            }
        }
    }
}
