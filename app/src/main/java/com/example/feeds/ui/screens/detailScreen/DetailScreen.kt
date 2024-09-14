package com.example.feeds.ui.screens.detailScreen

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.feeds.data.local.entity.NewsFeeds
import com.example.feeds.ui.State
import com.example.feeds.ui.screens.bookmarkScreen.BookmarkScreen
import com.example.feeds.ui.screens.homeScreen.HomeScreenViewModel

@Composable
fun NewsDetailsScreen(navController: NavController, newsId: Int) {
    // Fetch ViewModel using Hilt
    val viewModel: HomeScreenViewModel = hiltViewModel()

    val detailScreenViewModel: DetailScreenViewModel = hiltViewModel()

    // Collect the UI state
    val uiState = viewModel.state.collectAsState()

    val context = LocalContext.current

    // Safely check if the UI state is in success before accessing the data
    when (val state = uiState.value) {
        is State.Success -> {
            // Find the character by characterId
            val newsIndex = state.data.news.indexOfFirst { it.id == newsId }

            if (newsIndex != -1) {
                // Character found, now fetch the character details
                val currentNews = state.data.news[newsIndex]

                // Display the details in the UI
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState()),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    AsyncImage(
                        model = currentNews.image, // Display first image
                        contentDescription = null,
                        modifier = Modifier
                            .size(100.dp)
                            .clip(RoundedCornerShape(16.dp)),
                        contentScale = ContentScale.Crop
                    )
                    currentNews.title?.let { Text(text = it) }
                    // Uncomment if needed:
                    currentNews.publish_date?.let { Text(text = it) }
                    currentNews.author?.let { Text(text = it) }

                    // Back button to return to the previous screen
                    Button(onClick = {
                        navController.popBackStack()

                    }
                    ) {
                        Text(text = "Back")
                    }

                    Button(
                        onClick = {
                            detailScreenViewModel.addNews(currentNews)
                            Toast.makeText(context, "SAVED", Toast.LENGTH_SHORT).show()
                        }
                    ) {
                        Text(text = "ADD LOCAL")
                    }
                    Button(onClick = {
                        detailScreenViewModel.removeNews(currentNews)
                        Toast.makeText(context, "REMOVED", Toast.LENGTH_SHORT).show()
                    }) {
                        Text(text = "REMOVE LOCAL")
                    }
                }
            } else {
                // Handle case where character is not found
                Text(text = "Character not found", modifier = Modifier.fillMaxSize())
            }
        }
        is State.Loading -> {
            // Show loading UI
            CircularProgressIndicator(modifier = Modifier.fillMaxSize())
        }
        is State.Error -> {
            // Show error message
//            Text(text = "FAILED")
//            Text(text = (uiState as State.Error).error)
            BookmarkScreen(navController = navController)
        }
    }
}