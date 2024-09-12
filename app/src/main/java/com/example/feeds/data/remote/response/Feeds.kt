package com.example.feeds.data.remote.response

import com.example.feeds.data.local.model.NewsFeeds

data class Feeds(
    val available: Int,
    val news: List<NewsFeeds>,
    val number: Int,
    val offset: Int
)