package com.example.tugasjetpackcompose.Screen

import android.graphics.Paint.Align
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.tugasjetpackcompose.Data.Screens
import com.example.tugasjetpackcompose.Data.gitar
import com.example.tugasjetpackcompose.Data.gitarData
import com.example.tugasjetpackcompose.Data.konsedData
import com.example.tugasjetpackcompose.Data.konser
import com.example.tugasjetpackcompose.R
import com.example.tugasjetpackcompose.opensansbold
import com.example.tugasjetpackcompose.opensansregular


@Composable
fun Screen_1(
    navController: NavHostController
){
    val konser = remember{ konsedData.konser }
    val gitar = remember { gitarData.gitar}
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF627254))
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ){
            LazyRow(

            ){
                items(
                    items = konser, key = {it.id},
                    itemContent = {
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier.padding(horizontal = 8.dp)
                        ){
                            lazyrowLayout(konser = it){konserId ->
                                navController.navigate(Screens.Detail.route + "/$konserId")
                            }
                        }
                    }
                )
            }
            Spacer(modifier = Modifier.height(30.dp))
            LazyColumn(
            ){
                items(
                    items = gitar, key = {it.id},
                    itemContent = {
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier.padding(vertical = 8.dp)
                        ){
                            gitarLayout(gitar = it) {gitarId ->
                                navController.navigate(Screens.Detail_2.route + "/$gitarId")
                            }
                        }
                    }
                )
            }
        }
    }
}



@Composable
fun lazyrowLayout(
    konser: konser,
    onItemClicked : (Int) -> Unit
){
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(200.dp, 60.dp)
            .background(Color(0xFF76885B))
            .border(1.dp, color = Color(0xFFDDDDDD))
            .clickable {
                onItemClicked(konser.id)
            }
    ){
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(3.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ){
            image(konser)
            Text(text = "${konser.name}"
                ,fontFamily = FontFamily(Font(R.font.opensansregular))
            , fontSize = 10.sp
                , color = Color.White
            )
        }
    }
}


@Composable
fun image(
    konser: konser
){
    Image(painter = painterResource(id = konser.image),
        contentDescription = konser.name,
        modifier = Modifier
            .size(30.dp)

    )
}


@Composable
fun detailScreen(
    konserId : Int?
){
    val newKonserList = konsedData.konser.filter { it ->
        it.id == konserId
    }
    Column {
        if (konserId != null && newKonserList.isNotEmpty()){
            detailLayout(newKonserList = newKonserList)
        }
    }
}

@Composable
fun detailLayout(
    newKonserList : List<konser>
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
                .padding(20.dp)
        ){
            newKonserList.forEach {it ->
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
                    Text(text = "Harga Tiket: ${it.harga}"
                        , fontFamily = opensansregular
                        , fontSize = 14.sp
                        , color = Color.White
                        )
                }
            }
        }
    }
}

@Composable
fun gitarLayout(
    gitar: gitar,
    onItemClicked: (Int) -> Unit
){
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .width(325.dp)
            .height(100.dp)
            .background(
                Color(0xFF76885B), RoundedCornerShape(20.dp)
            )
            .border(1.dp, Color(0xFFEEEEEE))
            .clickable { onItemClicked(gitar.id) }
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .fillMaxSize()
                .padding(14.dp)
        ){
            Image(painter = painterResource(id = gitar.image),
                contentDescription = gitar.name,
                modifier = Modifier
                    .size(75.dp)
                )
           Column (
               verticalArrangement = Arrangement.SpaceAround,
               horizontalAlignment = Alignment.CenterHorizontally,
               modifier = Modifier
                   .fillMaxWidth()
           ){
               Text(text = "${gitar.name}", fontFamily = opensansregular, color = Color.White)
               Text(text = "Harga : Rp.${gitar.harga}", fontFamily = opensansregular, color = Color.White)
           }
        }
    }
}

@Composable
fun detailScreengitar(
    gitarId : Int?
) {
    val newGitarList = gitarData.gitar.filter { it ->
        it.id == gitarId
    }
    Column(
    ){
        if (gitarId != null && newGitarList.isNotEmpty()){
            detailLayoutgitar(newGitarList = newGitarList)
        } else {
            Text(text = "Gitar Tidak Ditemukan")
        }
    }
}

@Composable
fun detailLayoutgitar(
    newGitarList : List<gitar>
){
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
            newGitarList.forEach {it ->
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
                    Text(text = "Harga Gitar: ${it.harga}"
                        , fontFamily = opensansregular
                        , fontSize = 14.sp
                        , color = Color.White
                    )
                }
            }
        }
    }
}