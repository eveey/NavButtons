package com.evastos.navbuttons.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun NavButtonsTheme(
    content: @Composable () -> Unit
) {
    val systemUiColor = rememberSystemUiController()
    SideEffect {
        systemUiColor.run {
            setStatusBarColor(Color.Transparent)
            setNavigationBarColor(color = Color.Transparent, navigationBarContrastEnforced = false)
        }
    }
    MaterialTheme(
        content = content
    )
}
