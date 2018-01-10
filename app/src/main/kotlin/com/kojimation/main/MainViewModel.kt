package com.kojimation.main

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.kojimation.data.model.Diaries
import com.kojimation.data.repository.DiaryRepository
import com.kojimation.ext.toLiveData
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class MainViewModel @Inject constructor(private val repository: DiaryRepository) : ViewModel() {

    val diaries: LiveData<Diaries>

    init {
        diaries = repository.getDiaries(0)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .onErrorResumeNext(Flowable.empty())
                    .toLiveData()

    }
}
