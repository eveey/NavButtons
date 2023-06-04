@file:OptIn(ExperimentalAnimationApi::class)

package com.evastos.navbuttons.ui.screen

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import com.evastos.navbuttons.ui.animated.AnimationConstants.LongDurationMillis
import com.evastos.navbuttons.ui.animated.fadeThrough
import com.evastos.navbuttons.ui.button.NavMenuButton
import com.evastos.navbuttons.ui.scaffold.NavButtonsScaffold

@Composable
fun NavButtonsScreen() {
    var expanded by rememberSaveable { mutableStateOf(false) }

    AnimatedContent(
        modifier = Modifier,
        targetState = expanded,
        transitionSpec = fadeThrough(durationMillis = LongDurationMillis)
    ) { menuExpanded ->
        NavButtonsScaffold(
            modifier = Modifier,
            title = "Meld",
            navMenuButton = {
                NavMenuButton(
                    navMenuButtonState = if (menuExpanded) {
                        NavButtonCloseMenuState
                    } else {
                        NavButtonOpenMenuState
                    },
                    onClick = { expanded = menuExpanded.not() }
                )
            },
            menuExpanded = menuExpanded
        ) { }
    }
}

sealed class NavMenuButtonState(
    val imageVector: ImageVector,
    val contentDescription: String
)

object NavButtonOpenMenuState : NavMenuButtonState(
    imageVector = Icons.Filled.Menu,
    contentDescription = "Navigation open menu button"
)

object NavButtonCloseMenuState : NavMenuButtonState(
    imageVector = Icons.Filled.Close,
    contentDescription = "Navigation close menu button"
)
