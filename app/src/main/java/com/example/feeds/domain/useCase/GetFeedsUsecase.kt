package com.example.feeds.domain.useCase

import com.example.feeds.data.remote.response.Feeds
import com.example.feeds.domain.repository.FeedsRepository
import javax.inject.Inject

class GetFeedsUsecase @Inject constructor(private val feedsRepository: FeedsRepository) {
    suspend operator fun invoke(
        language: String,
        text: String?,
        country: String?
    ): Feeds {
        val response = feedsRepository.getFeeds(language, text, country)
        if(response.body() == null) {
            if (response.code() == 404) {
                throw Exception("Server Unreachable")
            } else if (response.code() == 500) {
                throw Exception("Server Error")
            } else if (response.code() == 401) {
                throw Exception("Unauthorized")
            } else if (response.code() == 400) {
                throw Exception("Bad Request")
            } else {
                throw Exception("No News Found")
            }
        }
        return feedsRepository.getFeeds(language, text, country).body()!!
    }
}