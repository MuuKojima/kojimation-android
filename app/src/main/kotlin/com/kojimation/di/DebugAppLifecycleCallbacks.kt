package com.kojimation.di

import android.app.Application
import com.kojimation.AppLifecycleCallbacks
import timber.log.Timber

class DebugAppLifecycleCallbacks : AppLifecycleCallbacks {

    override fun onCreate(application: Application) {
        Timber.plant(Timber.DebugTree())
    }

    override fun onTerminate(application: Application) {

    }
}

