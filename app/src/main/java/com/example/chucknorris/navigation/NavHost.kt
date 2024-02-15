package com.example.chucknorris.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.chucknorris.screens.HomeScreen
import com.example.chucknorris.screens.SplashScreen

@Composable
fun ChuckNorrisNavigation() {
    val navController = rememberNavController()
    NavHost(navController, ChuckNorrisScreens.SplashScreen.name) {
        composable(
            ChuckNorrisScreens.SplashScreen.name
        ) {
            SplashScreen(navController = navController)
        }

        composable(
            ChuckNorrisScreens.HomeScreen.name
        ) {
            HomeScreen()
        }
    }
}




