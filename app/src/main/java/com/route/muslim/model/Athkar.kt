package com.route.muslim.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Athkar(
    val content: String? = null
) : Parcelable
