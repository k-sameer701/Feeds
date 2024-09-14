package com.example.feeds.ui.navigation

import com.example.feeds.data.local.entity.NewsFeeds
import kotlinx.serialization.Serializable
import kotlinx.serialization.Serializer

@Serializable
sealed class NavRoutes {
    @Serializable
    data object HomeScreen: NavRoutes()

    @Serializable
    data object BookmarkScreen: NavRoutes()

    @Serializable
    data class NewsDetailsScreen(
        val newsID: Int
    ): NavRoutes()
}