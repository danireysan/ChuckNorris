package com.example.chucknorris.navigation

enum class ChuckNorrisScreens {
    SplashScreen,
    HomeScreen;

    companion object  {
        fun fromRoute(route: String?): ChuckNorrisScreens
                = when(route?.substringBefore("/")) {
                    SplashScreen.name -> SplashScreen
            null -> HomeScreen
            else -> throw IllegalArgumentException("Route $route is not recognized")
        }
    }
}