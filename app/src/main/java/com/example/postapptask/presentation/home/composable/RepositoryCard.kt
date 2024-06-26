package com.example.postapptask.presentation.home.composable

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.postapptask.R
import com.example.postapptask.common.theme.githubDarkBlue
import com.example.postapptask.common.theme.githubTextPrimary
import com.example.postapptask.common.theme.githubTextSecondary
import com.example.postapptask.data.model.GithubPostItem
import com.example.postapptask.presentation.navigation.screen.Screen

@Composable
fun RepositoryCard(
    repo: GithubPostItem,
    navController: NavController
) {
    val context = LocalContext.current
    Box(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 40.dp)
                .clip(shape = RoundedCornerShape(16.dp))
                .clickable {
                    navController.navigate(route = Screen.Details.route)
                    navController.currentBackStackEntry?.savedStateHandle
                        ?.set("githubPostItem",repo)
                },
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = githubDarkBlue
            )
        ) {
            Column(
                modifier = Modifier
                    .padding(top = 40.dp, start = 16.dp, end = 16.dp, bottom = 16.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = repo.owner?.login.toString(),
                    style = MaterialTheme.typography.titleLarge.copy(color = githubTextPrimary)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = repo.name.toString(),
                    style = MaterialTheme.typography.titleMedium.copy(color = githubTextSecondary)
                )
            }
        }

        Image(
            painter = rememberAsyncImagePainter(repo.owner?.avatarUrl),
            contentDescription = "User Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape)
                .align(Alignment.TopCenter)
        )


        IconButton(
            onClick = {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(repo.htmlUrl))
                context.startActivity(intent)
            },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.github),
                contentDescription = "Open URL",
                tint = githubTextSecondary
            )
        }
    }
}