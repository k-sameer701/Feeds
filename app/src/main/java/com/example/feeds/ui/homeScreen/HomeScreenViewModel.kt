package com.example.feeds.ui.homeScreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.feeds.data.local.model.NewsFeeds
import com.example.feeds.domain.useCase.GetFeedsUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(val usecase: GetFeedsUsecase): ViewModel() {
    init {
        viewModelScope.launch {
            val result = getNewsFeed()
            result.forEach {
                Log.d("TAG", it.author)
            }
        }

    }

    suspend fun getNewsFeed(): List<NewsFeeds> {
        return usecase.invoke("en", null, null).news
    }
}