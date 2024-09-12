package com.example.feeds.data.remote.network

import com.example.feeds.data.remote.response.Feeds
import com.example.feeds.utils.API_KEY
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.language.bm.Languages
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface FeedsApi {
    @GET("search-news")
    suspend fun getNews(
        @Query("country") country: String?,
        @Query("language") languages: String,
        @Query("content") newContent: String?,
        @Query("news-sources") newsSources: String? = "https://www.bbc.co.uk",
        @Query("api-key") apiKey: String = API_KEY,
    ): Response<Feeds>
}