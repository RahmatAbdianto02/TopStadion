package com.dicoding.topstadion

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Stadion(
    val name: String,
    val description: String,
    val photo: Int
) : Parcelable
