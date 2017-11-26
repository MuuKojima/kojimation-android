package com.kojimation.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.kojimation.R
import com.kojimation.data.repository.DiaryRepository
import com.kojimation.ext.toast
import dagger.android.AndroidInjection
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import timber.log.Timber
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var diaryRepository: DiaryRepository

    private val disposables = CompositeDisposable()
    private var offset = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        toast(R.string.common_request_error)
        load()
    }

    override fun onDestroy() {
        super.onDestroy()
        disposables.clear()
    }

    private fun load() {
        diaryRepository.getDiaries(offset)
                .observeOn(AndroidSchedulers.mainThread())
                .doAfterTerminate {
                }
                .subscribe({
                    Timber.d("通信" + it)
                }, {
                    toast(R.string.common_request_error)
                })
                .addTo(disposables)
    }
}
