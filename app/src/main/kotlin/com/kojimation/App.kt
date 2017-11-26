package com.kojimation

import dagger.android.support.DaggerApplication
import com.kojimation.di.DaggerAppComponent

class App : DaggerApplication() {
  override fun applicationInjector() = DaggerAppComponent.builder()
      .application(this)
      .build()
}
