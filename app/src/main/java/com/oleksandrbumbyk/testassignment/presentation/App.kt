package com.oleksandrbumbyk.testassignment.presentation

import com.oleksandrbumbyk.testassignment.BuildConfig
import com.oleksandrbumbyk.testassignment.presentation.injection.DaggerApplication
import timber.log.Timber

class App : DaggerApplication() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}
