package com.example.tugasjetpackcompose.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tugasjetpackcompose.R
import com.example.tugasjetpackcompose.opensansbold

@Composable
fun Screen_3() {
    Box(modifier = Modifier
        .background(Color(0xFF627254))
        .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ){
            Image(painter = painterResource(id = R.drawable.azizfrds),
                contentDescription = null )
            Spacer(modifier = Modifier.height(15.dp))
            Text(text = "Muhammad Azis Firdaus"
                , fontFamily = opensansbold
                , fontSize = 17.sp
                , color = Color.White
            )
            Spacer(modifier = Modifier.height(7.dp))
            Text(text = "muhammad.aziz@mhs.itenas.ac.id"
                , fontFamily = opensansbold
                , fontSize = 17.sp
                , color = Color.White
            )
            Spacer(modifier = Modifier.height(7.dp))
            Text(text = "Institut Teknologi Nasional Bandung"
                , fontFamily = opensansbold
                , fontSize = 17.sp
                , color = Color.White
            )
            Spacer(modifier = Modifier.height(7.dp))
            Text(text = "Informatika"
                , fontFamily = opensansbold
                , fontSize = 17.sp
                , color = Color.White
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun previe() {
    Screen_3()
}