package com.example.chucknorris.module

import com.example.chucknorris.network.ChuckNorrisApi
import com.example.chucknorris.repositories.CategoryRepository
import com.example.chucknorris.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun createApi(): ChuckNorrisApi = Retrofit.Builder().baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create()).build()
        .create(ChuckNorrisApi::class.java)

    @Provides
    @Singleton
    fun createRepo(api: ChuckNorrisApi) : CategoryRepository = CategoryRepository(api)
}