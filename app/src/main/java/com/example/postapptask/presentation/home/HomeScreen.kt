package com.example.postapptask.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.postapptask.common.theme.githubGradientBrush
import com.example.postapptask.presentation.home.composable.ReposList

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    val viewModel : HomeViewModel = viewModel()
    val reposList = viewModel.postState.value.list

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = githubGradientBrush)
    ) {
        Column {
            ReposList(reposList = reposList)
        }
    }
}