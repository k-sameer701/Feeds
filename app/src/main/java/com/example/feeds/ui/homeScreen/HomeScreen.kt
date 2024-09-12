package com.example.feeds.ui.homeScreen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    val viewModel: HomeScreenViewModel = hiltViewModel()
}