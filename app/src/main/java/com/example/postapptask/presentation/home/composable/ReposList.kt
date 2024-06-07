package com.example.postapptask.presentation.home.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.postapptask.data.model.GithubPostItem
import com.example.postapptask.presentation.home.HomeViewModel
import kotlinx.coroutines.delay

@Composable
fun ReposList(reposList: List<GithubPostItem>, navController: NavController,viewModel: HomeViewModel) {
    val scrollState = rememberLazyListState()
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp, alignment = Alignment.Top),
        state = scrollState,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(items = reposList){repo->
            RepositoryCard(repo = repo, navController = navController)
        }
        viewModel.postState.value.paginationErrorText?.let {
            item { Text(text = it, color = Color.White) }
        } ?: item (key = 1){ CircularProgressIndicator(color = Color.White) }
    }
    LaunchedEffect(reposList) {
        snapshotFlow { scrollState.layoutInfo.visibleItemsInfo }
            .collect {
                if (reposList.isEmpty()) return@collect

                if (it.last().key == 1){
                    delay(3000)
                    viewModel.goNextPage()
                }
            }
    }
}