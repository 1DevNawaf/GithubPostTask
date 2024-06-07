package com.example.postapptask.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.postapptask.common.composable.GithubPostAppBar
import com.example.postapptask.common.theme.githubDarkBlue
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
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            GithubPostAppBar(
                title = "My Repositories",
                subtitle = "Your Coding Hub, Simplified",
                color = githubDarkBlue,
            )
            if (reposList.isNotEmpty()) ReposList(reposList = reposList,navController = navController,viewModel)
            else Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ){
                viewModel.postState.value.firstCallErrorText?.let {
                    Text(
                        text = it,
                        color = Color.White,
                        textAlign = TextAlign.Center
                    )
                }?: CircularProgressIndicator(color = Color.White)
            }
        }
    }
}
