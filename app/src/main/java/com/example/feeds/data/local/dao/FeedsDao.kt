package com.example.feeds.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.feeds.data.local.entity.NewsFeeds
import kotlinx.coroutines.flow.Flow

@Dao
interface FeedsDao {

    @Query("SELECT * FROM news")
    fun getNews(): Flow<List<NewsFeeds>>

    @Insert
    suspend fun addNews(news: NewsFeeds)

    @Delete
    suspend fun deleteNews(news: NewsFeeds)
}