package com.example.feeds.ui.screens.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.feeds.data.local.entity.NewsFeeds
import com.example.feeds.ui.navigation.NavRoutes

@Composable
fun NewsList(navController: NavController, newsFeeds: List<NewsFeeds>) {
    LazyColumn {
        items(newsFeeds) { news ->
            Card(
                elevation = CardDefaults.elevatedCardElevation(10.dp),
                modifier = Modifier.padding(10.dp).clickable {
                    navController.navigate(NavRoutes.NewsDetailsScreen(news.id))
                }
            ) {
                Column(
                    modifier = Modifier

                ) {
                    AsyncImage(
                        model = news.image,
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(RoundedCornerShape(16.dp)),
                        contentScale = ContentScale.Crop
                    )
                    news.title?.let {
                        Text(
                            text = it,
                            modifier = Modifier.padding(10.dp)
                        )
                    }
                    news.author?.let {
                        Text(
                            text = it,
                            color = Color.Black,
                            modifier = Modifier.padding(10.dp)
                        )
                    }

                }
            }
        }
    }

}