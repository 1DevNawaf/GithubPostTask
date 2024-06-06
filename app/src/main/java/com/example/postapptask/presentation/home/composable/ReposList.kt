package com.example.postapptask.presentation.home.composable

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.postapptask.data.model.GithubPostItem

@Composable
fun ReposList(reposList: List<GithubPostItem>?) {
    val scrollState = rememberLazyListState()
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        state = scrollState
    ) {
        if (reposList!=null){
            items(items = reposList){repo->
                RepositoryCard(imageUrl =repo.owner?.avatarUrl.toString(),
                    ownerName =repo.owner?.login.toString(),
                    ownerInfo = repo.name.toString(),
                    ownerPage = repo.htmlUrl.toString()
                )
            }
        }

    }
    LaunchedEffect(reposList) {
        snapshotFlow { scrollState.layoutInfo.visibleItemsInfo }
            .collect {
                if (reposList == null) return@collect

                if (it.last().index+1>=reposList.size){
                    Log.d("MeTest",it.toString())
                }
            }
    }
}