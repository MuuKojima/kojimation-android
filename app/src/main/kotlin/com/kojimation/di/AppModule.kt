package com.kojimation.di

import com.kojimation.AppLifecycleCallbacks
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = arrayOf(ClientModule::class))
class AppModule {

    @Singleton
    @Provides
    fun provideAppLifecycleCallbacks(): AppLifecycleCallbacks = DebugAppLifecycleCallbacks()
}
