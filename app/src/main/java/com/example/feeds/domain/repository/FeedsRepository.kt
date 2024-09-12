package com.example.feeds.domain.repository

import com.example.feeds.data.remote.response.Feeds
import retrofit2.Response

interface FeedsRepository {
    suspend fun getFeeds(
        language: String,
        newsContent: String?,
        country: String?
    ): Response<Feeds>
}