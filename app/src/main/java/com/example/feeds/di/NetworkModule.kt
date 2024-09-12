package com.example.feeds.di

import android.content.Context
import com.example.feeds.FeedsApp
import com.example.feeds.data.remote.network.FeedsApi
import com.example.feeds.utils.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Provides
    @Singleton
    fun providesApplication(@ApplicationContext context: Context): FeedsApp{
        return context as FeedsApp
    }

    @Provides
    @Singleton
    fun providesContext(@ApplicationContext context: Context): Context {
        return context
    }

    @Provides
    @Singleton
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun providesFeedsApi(retrofit: Retrofit): FeedsApi {
        return retrofit.create(FeedsApi::class.java)
    }
}