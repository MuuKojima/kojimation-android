package com.kojimation.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.kojimation.R
import com.kojimation.ext.toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        toast(R.string.common_request_error)
    }
}
