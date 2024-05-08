package com.example.tugasjetpackcompose.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.tugasjetpackcompose.Data.Screens
import com.example.tugasjetpackcompose.Data.band
import com.example.tugasjetpackcompose.Data.bandData
import com.example.tugasjetpackcompose.opensansbold
import com.example.tugasjetpackcompose.opensansregular

@Composable
fun Screen_2(
    navController : NavHostController
){
    val bandPicture = remember { bandData.band }

    LazyVerticalStaggeredGrid(columns = StaggeredGridCells.Fixed(2),
        verticalItemSpacing = 4.dp,
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF627254))
    ){
        items(bandPicture, key = {it.id},
            itemContent = {
                piclayout(band = it){bandId ->
                    navController.navigate(Screens.Detail_3.route + "/$bandId")
                }
            })
    }
}

@Composable
fun detailScreenband(
    bandId : Int?
){
    val newBandList = bandData.band.filter {it ->
        it.id == bandId
    }
    Column {
        if (bandId != null && newBandList.isNotEmpty()) {
            detailScreenbandlayout(newBandList = newBandList)
        } else {
            Text(text = "Band Tidak Ditemukan")
        }
    }

}

@Composable
fun piclayout(
    band : band,
    onItemClicked : (Int) -> Unit

) {
    Image(painter = painterResource(id = band.image ),
        contentDescription = band.name,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable { onItemClicked(band.id) }
    )
}

@Composable
fun detailScreenbandlayout(
    newBandList: List<band>
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .background(Color(0xFF627254))
            .fillMaxSize()
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .fillMaxSize()
        ){
            newBandList.forEach {it ->
                Image(painter = painterResource(id = it.image),
                    contentDescription = it.name,
                    modifier = Modifier
                        .size(200.dp)
                )
                Text(text = "${it.name}"
                    , fontFamily = opensansbold
                    , fontSize = 17.sp
                    , color = Color.White
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "${it.description}"
                    , fontSize = 14.sp
                    , fontFamily = opensansregular
                    , color = Color.White
                )
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ){
                    Text(text = "Lagu - Lagu: ${listOf(it.song)}}"
                        , fontFamily = opensansregular
                        , fontSize = 14.sp
                        , color = Color.White
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun show() {

}


