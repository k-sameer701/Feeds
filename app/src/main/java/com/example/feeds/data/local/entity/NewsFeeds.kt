package com.example.feeds.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.feeds.data.local.database.Converter

@Entity(tableName = "news")
@TypeConverters(Converter::class)
data class NewsFeeds(
    val author: String?,
    val authors: List<String?>,
    val category: String?,
    @PrimaryKey val id: Int,
    val image: String?,
    val language: String?,
    val publish_date: String?,
    val sentiment: Double,
    val source_country: String?,
    val summary: String?,
    val text: String?,
    val title: String?,
    val url: String?,
    val video: String?
)