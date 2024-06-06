package com.example.postapptask.common.theme

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

val githubBackground = Color(0xFF24292E)
val githubPrimary = Color(0xFF0366D6)
val githubAccent = Color(0xFF28A745)
val githubTextPrimary = Color(0xFFFFFFFF)
val githubTextSecondary = Color(0xFF586069)
val githubDivider = Color(0xFF444D56)


val githubDarkGray = Color(0xFF24292E)
val githubDarkBlue = Color(0x0d1419)
val githubLighterGray = Color(0xFF2F363D)
val githubLighterBlueGray = Color(0xFF2D4257)
val githubLighterBlue = Color(0xFF2188FF)
val githubGreen = Color(0xFF28A745)

val githubGradientBrush = Brush.verticalGradient(
    colors = listOf(
        githubDarkGray,
        githubLighterGray
    )
)

val githubTopAppBarBrush = Brush.horizontalGradient(
    colors = listOf(
        githubBackground,
        githubLighterBlueGray
    )
)