package com.kojimation.data.repository

import com.kojimation.data.api.DiaryApi
import com.kojimation.data.model.Diaries
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class DiaryRepository @Inject constructor(
    private val diaryApi: DiaryApi
) {

  fun getDiaries(offset: Int): Single<Diaries> =
      diaryApi.getDiaries(LIMIT, offset).subscribeOn(Schedulers.io())

  companion object {
    private val LIMIT = 20
  }
}
