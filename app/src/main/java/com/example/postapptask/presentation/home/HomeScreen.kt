package com.example.postapptask.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.postapptask.common.composable.GithubPostAppBar
import com.example.postapptask.common.theme.githubGradientBrush
import com.example.postapptask.presentation.home.composable.ReposList


@Composable
fun HomeScreen(navController: NavController) {
    val viewModel : HomeViewModel = hiltViewModel()
    val reposList = viewModel.postState.value.list
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = githubGradientBrush)
    ) {
        Column {
            GithubPostAppBar(
                title = "My Repositories",
                subtitle = "Your Coding Hub, Simplified",
                color = MaterialTheme.colorScheme.background
            )
            ReposList(reposList = reposList,navController = navController)
        }
    }
}
