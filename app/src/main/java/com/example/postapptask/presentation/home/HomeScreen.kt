package com.example.postapptask.presentation.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    val viewModel : HomeViewModel = viewModel()
    val list = viewModel.postState.value.list
    if (list.isNotEmpty())
        Text(text = viewModel.postState.value.list.get(0).toString())
}