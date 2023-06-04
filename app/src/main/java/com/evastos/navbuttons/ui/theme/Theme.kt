package com.evastos.navbuttons.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun NavButtonsTheme(
    content: @Composable () -> Unit
) {
    val systemUiColor = rememberSystemUiController()
    SideEffect {
        systemUiColor.run {
            setStatusBarColor(
                color = SystemBars,
                darkIcons = true
            )
            setNavigationBarColor(
                color = SystemBars,
                darkIcons = true
            )
        }
    }
    MaterialTheme(
        content = content
    )
}
