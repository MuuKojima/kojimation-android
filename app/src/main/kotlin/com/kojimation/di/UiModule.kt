package com.kojimation.di

import android.arch.lifecycle.ViewModelProvider
import com.kojimation.main.MainActivity
import com.kojimation.main.MainModule
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class UiModule {
  @Binds
  abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

  @ContributesAndroidInjector(modules = arrayOf(MainModule::class))
  internal abstract fun contributeMainActivity(): MainActivity
}
