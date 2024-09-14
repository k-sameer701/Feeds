package com.example.feeds.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.feeds.ui.navigation.NavRoutes
import com.example.feeds.ui.screens.bookmarkScreen.BookmarkScreen
import com.example.feeds.ui.screens.detailScreen.NewsDetailsScreen
import com.example.feeds.ui.screens.homeScreen.HomeScreen
import com.example.feeds.ui.theme.FeedsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FeedsTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = NavRoutes.HomeScreen) {
                    composable<NavRoutes.HomeScreen> {
                        HomeScreen(navController = navController)
                    }
                    composable<NavRoutes.NewsDetailsScreen> { navBackstackEntry ->
                        val args = navBackstackEntry.toRoute<NavRoutes.NewsDetailsScreen>()
                        NewsDetailsScreen(navController = navController, args.newsID)
                    }
                    composable<NavRoutes.BookmarkScreen> {
                        BookmarkScreen(navController = navController)
                    }
                }
            }
        }
    }
}