package com.example.postapptask.presentation.details.composable

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun RepoInfoText(label: String, value: String?) {
    Text(
        text = "- $label: ${value ?: "No data provided"} ",
        style = MaterialTheme.typography.titleMedium
    )
}