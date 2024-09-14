package com.example.feeds.di

import android.content.Context
import androidx.room.Dao
import androidx.room.Database
import com.example.feeds.data.local.database.NewsFeedsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Provides
    @Singleton
    fun providesNewsDatabase(context: Context): NewsFeedsDatabase {
        return NewsFeedsDatabase.getDatabase(context)
    }
}