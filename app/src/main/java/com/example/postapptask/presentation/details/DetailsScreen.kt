package com.example.postapptask.presentation.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.postapptask.common.composable.GithubPostAppBar
import com.example.postapptask.common.theme.githubDarkBlue
import com.example.postapptask.common.theme.githubGradientBrush
import com.example.postapptask.presentation.details.composable.CustomIconButton
import com.example.postapptask.presentation.details.composable.DetailsCard
import com.example.postapptask.presentation.details.composable.UserAvatar


@Composable
fun DetailsScreen(navController: NavHostController,viewModel: DetailsViewModel) {
    val repoState by viewModel.postState.collectAsState()
    val repo = repoState.githubPostItem
    Column {
        GithubPostAppBar(
            title = "Repository Details",
            subtitle = "Elegantly Present Your Repositories",
            color = githubDarkBlue
        )
        Box(
            modifier = Modifier
                .background(brush = githubGradientBrush)
                .padding(horizontal = 16.dp, vertical = 12.dp)
                .fillMaxWidth()
                .windowInsetsPadding(insets = WindowInsets.systemBars)
        ) {
            DetailsCard(repo)
            UserAvatar(repo?.owner?.avatarUrl)
            CustomIconButton(repo?.htmlUrl)
        }
    }
}


