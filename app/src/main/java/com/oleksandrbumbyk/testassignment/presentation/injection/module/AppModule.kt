package com.oleksandrbumbyk.testassignment.presentation.injection.module

import android.content.Context
import com.oleksandrbumbyk.testassignment.domain.Schedulers
import com.oleksandrbumbyk.testassignment.presentation.injection.DaggerApplication
import com.oleksandrbumbyk.testassignment.presentation.navigation.Navigator
import com.oleksandrbumbyk.testassignment.presentation.navigation.NavigatorImpl
import com.oleksandrbumbyk.testassignment.presentation.scheduler.AppSchedulers
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
internal class AppModule {

    @Provides
    @Singleton
    internal fun providesContext(application: DaggerApplication): Context = application.applicationContext

    @Provides
    @Singleton
    internal fun provideSchedulers(): Schedulers = AppSchedulers()

    @Provides
    @Singleton
    internal fun provideNavigator(): Navigator = NavigatorImpl()
}
