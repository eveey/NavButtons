package com.evastos.navbuttons

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.evastos.navbuttons.ui.screen.NavButtonsScreen
import com.evastos.navbuttons.ui.theme.NavButtonsTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavButtonsTheme {
                NavButtonsScreen()
            }
        }
    }
}
