package com.example.tugasjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import com.example.tugasjetpackcompose.Screen.navigationBar
import com.example.tugasjetpackcompose.ui.theme.TugasjetpackcomposeTheme

val opensansregular = FontFamily(Font(R.font.opensansregular))
val opensansmedium = FontFamily(Font(R.font.opensansmedium))
val opensansbold = FontFamily(Font(R.font.opensansbold))
val opensansthick = FontFamily(Font(R.font.opensanslight))
val opensanssemibold = FontFamily(Font(R.font.opensanssemibold))

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            navigationBar()
        }
    }
}

