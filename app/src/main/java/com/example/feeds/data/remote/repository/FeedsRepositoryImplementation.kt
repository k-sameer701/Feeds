package com.example.feeds.data.remote.repository

import com.example.feeds.data.remote.network.FeedsApi
import com.example.feeds.data.remote.response.Feeds
import com.example.feeds.domain.repository.FeedsRepository
import retrofit2.Response
import javax.inject.Inject

class FeedsRepositoryImplementation @Inject constructor(private val api: FeedsApi): FeedsRepository {
    override suspend fun getFeeds(
        language: String,
        newsContent: String?,
        country: String?
    ): Response<Feeds> {
        return api.getNews(country, language, newsContent)
    }

}