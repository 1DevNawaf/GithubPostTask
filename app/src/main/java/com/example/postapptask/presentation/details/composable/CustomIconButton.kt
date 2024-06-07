package com.example.postapptask.presentation.details.composable

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.postapptask.R

@Composable
fun BoxScope.CustomIconButton(htmlUrl: String?) {
    val context = LocalContext.current
    IconButton(
        onClick = {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(htmlUrl))
            context.startActivity(intent)
        },
        modifier = Modifier
            .align(Alignment.BottomEnd)
            .padding(vertical = 16.dp, horizontal = 24.dp)
            .size(70.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.github),
            contentDescription = "Open URL",
            tint = Color.White,
        )
    }
}