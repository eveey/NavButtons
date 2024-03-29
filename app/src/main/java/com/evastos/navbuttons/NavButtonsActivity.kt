package com.evastos.navbuttons

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.evastos.navbuttons.ui.screen.NavButtonsScreen
import com.evastos.navbuttons.ui.theme.NavButtonsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NavButtonsActivity : ComponentActivity() {
    val viewModel: NavButtonsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavButtonsTheme {
                NavButtonsScreen()
            }
        }
    }
}
