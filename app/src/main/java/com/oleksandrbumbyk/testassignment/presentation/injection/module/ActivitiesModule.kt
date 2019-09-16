package com.oleksandrbumbyk.testassignment.presentation.injection.module

import com.oleksandrbumbyk.testassignment.presentation.injection.module.main.MainModule
import com.oleksandrbumbyk.testassignment.presentation.injection.scope.MainScope
import com.oleksandrbumbyk.testassignment.presentation.view.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class ActivitiesModule {

    @MainScope
    @ContributesAndroidInjector(modules = [MainModule::class])
    internal abstract fun contributeMainActivity(): MainActivity
}
