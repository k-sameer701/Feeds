package com.example.feeds.ui.screens.homeScreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.feeds.data.local.entity.NewsFeeds
import com.example.feeds.data.remote.response.Feeds
import com.example.feeds.domain.useCase.GetFeedsUsecase
import com.example.feeds.ui.State
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(private val usecase: GetFeedsUsecase): ViewModel() {
    private val _state = MutableStateFlow<State<Feeds>>(State.Loading)
    val state = _state as StateFlow<State<Feeds>>

    private var job: Job? = null

    init {
        getNews()
    }

    fun getNews(text: String? = null, country: String? = null) {
        job?.cancel()
        job = viewModelScope.launch {
            _state.tryEmit(State.Loading)
            try {
                val result = usecase.invoke("en", text, country)
                _state.tryEmit(State.Success(result))
            } catch (e: Exception) {
                _state.tryEmit(State.Error(e.message.toString()))
            }
        }
    }
}