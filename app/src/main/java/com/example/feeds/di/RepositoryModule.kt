package com.example.feeds.di

import androidx.compose.animation.core.rememberTransition
import com.example.feeds.data.remote.network.FeedsApi
import com.example.feeds.data.remote.repository.FeedsRepositoryImplementation
import com.example.feeds.domain.repository.FeedsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Provides
    @Singleton
    fun providesFeedsRepository(api: FeedsApi): FeedsRepository {
        return FeedsRepositoryImplementation(api)
    }
}