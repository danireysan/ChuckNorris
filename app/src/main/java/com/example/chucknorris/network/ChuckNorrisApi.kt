package com.example.chucknorris.network

import com.example.chucknorris.models.Categories
import retrofit2.http.GET

interface ChuckNorrisApi {
    @GET("/jokes/categories")
    suspend fun getCategories() : Categories
}
