package com.kojimation.main

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.kojimation.R
import com.kojimation.ext.observe
import com.kojimation.ext.toast
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import timber.log.Timber
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HasSupportFragmentInjector {

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory
    @Inject lateinit var androidInjector: DispatchingAndroidInjector<Fragment>
    private lateinit var viewModel: MainViewModel

    override fun supportFragmentInjector() = androidInjector

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        viewModel = ViewModelProviders.of(this!!, viewModelFactory).get(MainViewModel::class.java)
        viewModel.diaries.observe(this) {
            Timber.d("KOJIMATION -> " + it.toString())
            toast(R.string.common_request_success)
        }
    }
}
