package com.kojimation.data.model

import com.squareup.moshi.Json

data class Diaries(
    @Json(name = "next_offset")
    val nextOffset: Int,
    val items: List<Diary>
)
