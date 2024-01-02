package com.route.muslim.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Hadeth(
    val title: String? = null,
    val content: String? = null
) : Parcelable
