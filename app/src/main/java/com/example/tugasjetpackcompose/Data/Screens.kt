package com.example.tugasjetpackcompose.Data

sealed class Screens(val route : String){
    object navigationBar : Screens("navigationBar")
    object Screen_1 : Screens("Screen_1")
    object Screen_2 : Screens("Screen_2")
    object Screen_3 : Screens("Screen_3")
    object Detail : Screens("DetailScreen")
    object Detail_2 : Screens("detailScreengitar")
    object Detail_3 : Screens("detailScreenband")
}
