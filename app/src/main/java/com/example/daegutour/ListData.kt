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
    val longitude : Float

): Parcelable