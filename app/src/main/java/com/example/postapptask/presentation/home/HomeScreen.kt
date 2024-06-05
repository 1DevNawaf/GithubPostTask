package com.example.postapptask.presentation.home

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    val viewModel : HomeViewModel = viewModel()
    val list = viewModel.postState.value.list
    if (list?.isNotEmpty() == true)
        Text(text = viewModel.postState.value.list.toString())
}