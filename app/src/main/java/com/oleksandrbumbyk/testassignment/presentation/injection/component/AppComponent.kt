package com.oleksandrbumbyk.testassignment.presentation.injection.component

import com.oleksandrbumbyk.testassignment.presentation.injection.DaggerApplication
import com.oleksandrbumbyk.testassignment.presentation.injection.module.ActivitiesModule
import com.oleksandrbumbyk.testassignment.presentation.injection.module.AppModule
import com.oleksandrbumbyk.testassignment.presentation.injection.module.DataModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivitiesModule::class,
        AppModule::class,
        DataModule::class]
)
internal interface AppComponent : AndroidInjector<DaggerApplication> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<DaggerApplication>()
}
