package com.example.chucknorris.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.chucknorris.navigation.ChuckNorrisScreens
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController) {
    LaunchedEffect(key1 = true) {
        delay(2000L)

        navController.navigate(ChuckNorrisScreens.HomeScreen.name) {
            popUpTo(ChuckNorrisScreens.SplashScreen.name) { inclusive = true }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Color(0xFFF05A24)
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Chuck Norris IO",
            style = TextStyle(
                fontSize = 21.sp,
                color = Color.White
            ),
        )
    }
}

