@file:OptIn(ExperimentalAnimationApi::class)

package com.evastos.navbuttons.ui.screen

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.Crossfade
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.AnimationConstants.DefaultDurationMillis
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.res.stringResource
import com.evastos.navbuttons.R
import com.evastos.navbuttons.navigation.NavButtonsAppState
import com.evastos.navbuttons.navigation.NavButtonsNavHost
import com.evastos.navbuttons.navigation.rememberNavButtonsAppState
import com.evastos.navbuttons.ui.animation.fadeThrough
import com.evastos.navbuttons.ui.button.NavMenuButton
import com.evastos.navbuttons.ui.theme.BackgroundBlur
import com.evastos.navbuttons.ui.theme.NoBlur

@Composable
fun NavButtonsScreen(
    appState: NavButtonsAppState = rememberNavButtonsAppState(),
) {
    var menuShown by rememberSaveable { mutableStateOf(false) }

    AnimatedContent(
        modifier = Modifier,
        targetState = menuShown,
        transitionSpec = fadeThrough(),
    ) { isMenuOpen ->
        val backgroundBlur by animateDpAsState(
            if (isMenuOpen) {
                BackgroundBlur
            } else {
                NoBlur
            },
            animationSpec = tween(),
        )

        NavButtonsScaffold(
            modifier = Modifier,
            title = stringResource(id = R.string.app_name),
            navMenuButton = {
                Crossfade(
                    targetState = menuShown,
                    animationSpec = tween(durationMillis = DefaultDurationMillis),
                ) { isMenuShown ->
                    if (isMenuShown) {
                        NavMenuButton(
                            imageVector = Icons.Filled.Close,
                            contentDescription = "Close menu button",
                            onClick = { menuShown = false },
                            onLongClick = { menuShown = false },
                        )
                    } else {
                        NavMenuButton(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = "Open menu button",
                            onClick = { menuShown = true },
                            onLongClick = { menuShown = true },
                        )
                    }
                }
            },
            backgroundBlur = backgroundBlur,
        ) { paddingValues ->
            NavButtonsNavHost(
                appState = appState,
                modifier = Modifier
                    .blur(backgroundBlur),
                paddingValues = paddingValues,
            )
        }
    }
}
