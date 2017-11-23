package com.kojimation.ext

import android.content.Context
import android.support.annotation.StringRes
import android.widget.Toast

fun Context.toast(@StringRes message: Int) = Toast.makeText(this, this.getString(message), Toast.LENGTH_LONG).show()
