package com.example.laboratorio_05.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


data class MovieModel(
    val name: String,
    val category: String,
    val description: String,
    val qualification: String
)