package com.kojimation.data.repository

import com.kojimation.data.api.DiaryApi
import com.kojimation.data.model.Diaries
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class DiaryRepository @Inject constructor(
    private val diaryApi: DiaryApi
) {

  fun getDiaries(offset: Int) = diaryApi.getDiaries(LIMIT, offset)

  companion object {
    private val LIMIT = 20
  }
}
