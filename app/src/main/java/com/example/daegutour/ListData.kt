package com.example.daegutour

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ListData (
    val name : String,
    val address : String,
    val img : Int,
    val desc : String,
    val latitude : Float,
    val longitude : Float,
    val data : Int,
    val google : String,
    val naver : String,
    val trip : String,
    val avg : String,
    val wordCloud : Int
): Parcelable