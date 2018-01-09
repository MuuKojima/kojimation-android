package com.kojimation.di

import com.kojimation.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class UiModule {

  @ContributesAndroidInjector()
  internal abstract fun contributeMainActivity(): MainActivity
}
