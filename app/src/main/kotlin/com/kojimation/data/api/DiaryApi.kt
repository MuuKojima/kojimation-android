package com.kojimation.data.api

import io.reactivex.Single
import com.kojimation.data.model.Diaries
import retrofit2.http.GET
import retrofit2.http.Query

interface DiaryApi {
  @GET("/api/v1/diaries")
  fun getDiaries(
      @Query("limit") limit: Int,
      @Query("offset") offset: Int
  ): Single<Diaries>
}
