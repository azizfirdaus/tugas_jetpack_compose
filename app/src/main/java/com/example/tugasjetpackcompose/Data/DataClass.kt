package com.example.tugasjetpackcompose.Data

import android.location.Location
import java.util.Date


data class band(
    val id : Int,
    val name : String,
    val description : String,
    val image : Int = 0,
    val song : List<String>
)
data class konser(
    val id: Int,
    val name : String,
    val description: String,
    val image: Int = 0,
    val harga: Int,
)
data class gitar(
    val id: Int,
    val name: String,
    val description: String,
    val image: Int = 0,
    val harga: Int,
)
