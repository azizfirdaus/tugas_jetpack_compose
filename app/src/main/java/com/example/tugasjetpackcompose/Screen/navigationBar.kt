package com.example.tugasjetpackcompose.Screen

import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.tugasjetpackcompose.Data.Screens
import com.example.tugasjetpackcompose.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun navigationBar() {
    val navController : NavHostController = rememberNavController()
    val selected = remember { mutableStateOf(Icons.Default.Home) }
    val iconRide by remember { mutableStateOf(R.drawable.icon_ride) }
    val iconGrid by remember { mutableStateOf(R.drawable.icon_grid) }
    val iconAbout by remember { mutableStateOf(R.drawable.icon_about) }
    val isClickedRide = remember { mutableStateOf(false) }
    val isClickedGrid = remember { mutableStateOf(false) }
    val isClickedAbout = remember { mutableStateOf(false) }
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        modifier = Modifier
            .background(Color(0xFFDDDDD)),
        bottomBar = {
            BottomAppBar(
                containerColor = Color(0xFFEEEEE), tonalElevation = 10.dp
            ) {
                IconButton(onClick = {
                    isClickedRide.value = true
                    isClickedGrid.value = false
                    isClickedAbout.value = false
                  navController.navigate(Screens.Screen_1.route){
                      popUpTo(0)
                  }
                }, modifier = Modifier.weight(1f)
                    ){
                    Image(painter = painterResource(id = if (isClickedRide.value) iconRide else R.drawable.icon_ride_clicked ),
                        contentDescription = null,
                        modifier = Modifier
                            .size(26.dp)
                    )
                }
                IconButton(onClick = {
                    isClickedRide.value = false
                    isClickedGrid.value = true
                    isClickedAbout.value = false
                    navController.navigate(Screens.Screen_2.route){
                        popUpTo(0)
                    }
                }, modifier = Modifier.weight(1f)
                    ){
                    Image(painter = painterResource(id = if (isClickedGrid.value) iconGrid else R.drawable.icon_grid_clicked),
                        contentDescription = null,
                        modifier = Modifier
                            .size(26.dp)
                    )
                }
                IconButton(onClick = {
                    isClickedRide.value = false
                    isClickedGrid.value = false
                    isClickedAbout.value = true
                    navController.navigate(Screens.Screen_3.route){
                        popUpTo(0)
                    }
                }, modifier = Modifier.weight(1f)
                    ){
                    Image(painter = painterResource(id = if (isClickedAbout.value) iconAbout else R.drawable.icon_about_clicked),
                        contentDescription = null,
                        modifier = Modifier
                            .size(26.dp)
                    )
                }
            }
        },
        topBar = {
            when(currentRoute) {
                Screens.Screen_1.route -> {
                    TopAppBar(
                        title = { Text(text = "Screen 1") }
                    )
                }
                Screens.Screen_2.route -> {
                    TopAppBar(
                        title = { Text(text = "Screen 2") }
                    )
                }
                Screens.Screen_3.route -> {
                    TopAppBar(
                        title = { Text(text = "About") }
                    )
                } else -> {
                    TopAppBar(title = { Text(text = "Detail Screen")},
                        navigationIcon = {
                            IconButton(onClick = { navController.popBackStack()
                            }
                            ){
                                Icon(Icons.Filled.ArrowBack, contentDescription = null)
                            }
                        })
                }
            }
        }
    ){paddingValues ->
        NavHost(navController = navController, startDestination = Screens.Screen_1.route,
            modifier = Modifier.padding(paddingValues)){
            composable(Screens.Screen_1.route){ Screen_1(navController) }
            composable(Screens.Screen_2.route) { Screen_2(navController) }
            composable(Screens.Screen_3.route) { Screen_3() }
            composable(Screens.Detail.route + "/{konserId}",
                arguments = listOf(navArgument("konserId"){ type = NavType.IntType})
                ){ navBackStackEntry ->
                detailScreen(konserId = navBackStackEntry.arguments?.getInt("konserId")
                )
            }
            composable(Screens.Detail_2.route + "/{gitarId}",
                arguments = listOf(navArgument("gitarId"){type = NavType.IntType})
            ){navBackStackEntry ->
                detailScreengitar(gitarId = navBackStackEntry.arguments?.getInt("gitarId"))
            }
            composable(Screens.Detail_3.route + "/{bandId}",
                arguments = listOf(navArgument("bandId"){type = NavType.IntType})
            ){navBackStackEntry ->
                detailScreenband(bandId = navBackStackEntry.arguments?.getInt("bandId"))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun view() {
    navigationBar()
}
