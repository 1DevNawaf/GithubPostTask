package com.example.postapptask.presentation.details.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

@Composable
fun BoxScope.UserAvatar(url: String?) {
    Image(
        painter = rememberAsyncImagePainter(url),
        contentDescription = "User Image",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(140.dp)
            .clip(CircleShape)
            .align(Alignment.TopCenter)
    )
}