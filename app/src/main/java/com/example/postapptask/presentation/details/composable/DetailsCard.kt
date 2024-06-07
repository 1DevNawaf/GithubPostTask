package com.example.postapptask.presentation.details.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.postapptask.data.model.GithubPostItem

@Composable
fun DetailsCard(repo: GithubPostItem?) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 110.dp)
            .clip(shape = RoundedCornerShape(16.dp)),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background
        )
    ) {
        Column(
            modifier = Modifier
                .padding(top = 40.dp, start = 16.dp, end = 16.dp, bottom = 16.dp)
                .fillMaxWidth()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(18.dp))
            Text(
                text = repo?.owner?.login.toString(),
                style = MaterialTheme.typography.displayMedium
            )
            Spacer(modifier = Modifier.height(8.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 35.dp)
            ) {
                Text(
                    text = "${repo?.name.toString()}: ",
                    style = MaterialTheme.typography.titleLarge
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = repo?.description ?: "No description provided",
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(modifier = Modifier.height(20.dp))
                RepoInfoText("Repository ID",repo?.id.toString())
                Spacer(modifier = Modifier.height(8.dp))
                RepoInfoText("Used language",repo?.language)
                Spacer(modifier = Modifier.height(8.dp))
                RepoInfoText("Created at",repo?.createdAt)
                Spacer(modifier = Modifier.height(8.dp))
                RepoInfoText("Last Updated",repo?.updatedAt)
            }
        }
    }
}

