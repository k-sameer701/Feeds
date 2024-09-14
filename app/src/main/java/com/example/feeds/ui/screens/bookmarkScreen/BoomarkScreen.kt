package com.example.feeds.ui.screens.bookmarkScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.feeds.ui.screens.common.NewsList

@Composable
fun BookmarkScreen(navController: NavController) {
    val viewModel: BookmarkViewModel = hiltViewModel()
    val bookmarks = viewModel.getBookmarks().collectAsState(initial = listOf())
    val offlineNews = bookmarks.value
    Column {
        Text(text = "Bookmarks", fontSize = 30.sp)
        Spacer(modifier = Modifier.size(16.dp))
        NewsList(navController = navController, newsFeeds = offlineNews)
//        NewsListView(bookmarks.value, onClick = {
//            //navHostController.navigate(NavRoute.createNewsDetailsRoute(it, true))
//        })
    }
}