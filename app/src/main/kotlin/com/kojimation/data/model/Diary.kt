package com.kojimation.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Diary constructor(
    val title: String,
    val date: String,
    val body: String
) : Parcelable
