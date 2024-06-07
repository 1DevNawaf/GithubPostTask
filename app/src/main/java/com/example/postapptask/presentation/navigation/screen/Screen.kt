package com.example.postapptask.presentation.navigation.screen

sealed class Screen(val route: String) {
    data object Home : Screen("home")
    data object Details : Screen("details")
}