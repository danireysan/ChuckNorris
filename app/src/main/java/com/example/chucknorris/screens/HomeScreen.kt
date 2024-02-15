package com.example.chucknorris.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.chucknorris.screens.viewmodel.CategoryViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    categoryViewModel: CategoryViewModel = hiltViewModel()
) {
    val isLoading = categoryViewModel.isLoading.observeAsState(initial = true)
    val categoriesResult = categoryViewModel.categories.observeAsState()
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Chuck Norris IO",
                        color = Color.White
                    )
                },
                colors = TopAppBarDefaults.largeTopAppBarColors(
                    containerColor = Color(0xFFF05A24)
                )
            )
        }
    ) {
        Box(
            modifier = Modifier
                .padding(it)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            if (isLoading.value) {
                CircularProgressIndicator(color = Color(0xFFF05A24))
            }

            categoriesResult.value?.let { result ->
                result.fold(
                    onSuccess = { categories ->
                        LazyColumn() {
                            items(categories.size) { index ->
                                SuggestionChip(
                                    label = { Text(text = categories[index]) },
                                    onClick = { /*TODO*/ })
                            }
                        }
                    },
                    onFailure = { error ->
                        Text(text = error.localizedMessage ?: "An error occurred")
                    }
                )
            }

        }
    }
}