package com.example.postapptask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.postapptask.common.theme.PostAppTaskTheme
import com.example.postapptask.data.model.GithubPostItem
import com.example.postapptask.presentation.details.DetailsScreen
import com.example.postapptask.presentation.details.DetailsViewModel
import com.example.postapptask.presentation.home.HomeScreen
import com.example.postapptask.presentation.navigation.screen.Screen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PostAppTaskTheme {
                NavGraph()
            }
        }
    }
}

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    
    NavHost(navController = navController, startDestination = Screen.Home.route ){
        composable(route=Screen.Home.route){
            HomeScreen(navController = navController)
        }
        composable(
            route = Screen.Details.route,
        ){entry->
            val detailsViewModel : DetailsViewModel = hiltViewModel()
            LaunchedEffect(key1 = Unit) {
                detailsViewModel.setGithubPostItem(navController.currentBackStackEntry
                    ?.savedStateHandle?.get<GithubPostItem>("githubPostItem"))
            }

            DetailsScreen(navController = navController, viewModel = detailsViewModel)
        }
    }
}