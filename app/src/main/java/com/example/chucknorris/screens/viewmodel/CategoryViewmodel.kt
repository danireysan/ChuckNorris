package com.example.chucknorris.screens.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chucknorris.models.Categories
import com.example.chucknorris.repositories.CategoryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(
    private val repository: CategoryRepository
) : ViewModel() {
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading
    private val _categories = MutableLiveData<Result<Categories>>()
    val categories: LiveData<Result<Categories>> get() = _categories

    init {
        fetchCategories()
    }
    private fun fetchCategories() {
        viewModelScope.launch {
            _isLoading.postValue(true)
            repository.getCategories().onEach {
                _isLoading.postValue(false)
            }.collect {
                _categories.postValue(it)
            }
        }
    }
}