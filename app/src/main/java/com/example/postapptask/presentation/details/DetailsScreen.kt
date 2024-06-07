package com.example.postapptask.presentation.details

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController


@Composable
fun DetailsScreen(navController: NavHostController,viewModel: DetailsViewModel) {
    val repo by viewModel.postState.collectAsState()
    Text(repo.githubPostItem?.name.toString())
}