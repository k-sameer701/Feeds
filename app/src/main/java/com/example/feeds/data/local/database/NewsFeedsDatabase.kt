package com.example.feeds.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.feeds.data.local.dao.FeedsDao
import com.example.feeds.data.local.entity.NewsFeeds


@Database(entities = [NewsFeeds::class], version = 1, exportSchema = false)
abstract class NewsFeedsDatabase : RoomDatabase() {
    abstract fun newsDao(): FeedsDao

    companion object {
        const val DATABASE_NAME = "news_db"

        @JvmStatic
        fun getDatabase(context: Context): NewsFeedsDatabase {
            return Room.databaseBuilder(context, NewsFeedsDatabase::class.java, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}