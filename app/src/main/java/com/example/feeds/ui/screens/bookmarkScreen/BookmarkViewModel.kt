package com.example.feeds.ui.screens.bookmarkScreen

import androidx.lifecycle.ViewModel
import com.example.feeds.data.local.database.NewsFeedsDatabase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BookmarkViewModel @Inject constructor(database: NewsFeedsDatabase) : ViewModel() {
    private val newsDao = database.newsDao()
    fun getBookmarks() = newsDao.getNews()
}