package com.example.chucknorris

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.chucknorris.navigation.ChuckNorrisNavigation
import com.example.chucknorris.ui.theme.ChuckNorrisTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChuckNorrisTheme {
                // A surface container using the 'background' color from the theme
                ChuckNorrisNavigation()
            }
        }
    }
}
