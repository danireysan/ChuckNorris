package com.example.chucknorris.repositories

import com.example.chucknorris.models.Categories
import com.example.chucknorris.network.ChuckNorrisApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CategoryRepository @Inject constructor(
    private val api: ChuckNorrisApi
){
    fun getCategories() : Flow<Result<Categories>> {
        return flow {
            emit(Result.success(api.getCategories()))
        }.catch {
            emit(Result.failure(RuntimeException("Something went wrong")))
        }
    }
}
