package com.evastos.navbuttons.ui.screen

import androidx.activity.compose.BackHandler
import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.Transition
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.layout.offset
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.ExperimentalTextApi
import com.evastos.navbuttons.R
import com.evastos.navbuttons.navigation.NavButtonsAppState
import com.evastos.navbuttons.navigation.NavButtonsNavHost
import com.evastos.navbuttons.navigation.NavRouter
import com.evastos.navbuttons.navigation.rememberNavButtonsAppState
import com.evastos.navbuttons.ui.NavMenuActions
import com.evastos.navbuttons.ui.animation.AnimatedExplosion
import com.evastos.navbuttons.ui.button.NavMenuActionButton
import com.evastos.navbuttons.ui.button.NavMenuButton
import com.evastos.navbuttons.ui.theme.MinFabSize

@Composable
fun NavButtonsScreen(
    appState: NavButtonsAppState = rememberNavButtonsAppState()
) {
    var menuExpanded by rememberSaveable { mutableStateOf(false) }

    appState.navController.enableOnBackPressed(menuExpanded.not())
    BackHandler(enabled = menuExpanded) {
        if (menuExpanded) {
            menuExpanded = false
        }
    }

    val menuTransition = updateTransition(
        targetState = menuExpanded,
        label = "menu expansion animation"
    )

    NavButtonsScaffold(
        modifier = Modifier,
        title = stringResource(id = R.string.app_name),
        navMenuButton = {
            NavButtonsMenu(
                menuExpanded = menuExpanded,
                menuTransition = menuTransition,
                onMenuButtonClick = {
                    menuExpanded = !menuExpanded
                },
                onMenuButtonRelease = {
                    menuExpanded = true
                },
                onMenuActionClick = { navRouter ->
                    menuExpanded = false
                    appState.navigateToDestination(navRouter)
                }
            )
        },
        menuTransition = menuTransition
    ) {
        NavButtonsNavHost(
            appState = appState
        )
    }
}

@OptIn(ExperimentalTextApi::class)
@Composable
fun NavButtonsMenu(
    menuExpanded: Boolean,
    menuTransition: Transition<Boolean>,
    onMenuButtonClick: () -> Unit,
    onMenuButtonRelease: () -> Unit,
    onMenuActionClick: (NavRouter) -> Unit
) {
    var menuButtonVisible by rememberSaveable { mutableStateOf(true) }

    AnimatedExplosion(
        transition = menuTransition,
        animatables = NavMenuActions,
        animatableSize = MinFabSize
    ) { offset, animatable ->
        NavMenuActionButton(
            modifier = Modifier
                .offset(
                    x = offset.x,
                    y = offset.y
                ),
            imageVector = animatable.icon,
            menuExpanded = menuExpanded,
            action = stringResource(id = animatable.action),
            onClick = {
                menuButtonVisible = true
                onMenuActionClick(animatable)
            }
        )
    }

    if (menuButtonVisible) {
        Crossfade(
            targetState = menuExpanded
        ) { expanded ->
            NavMenuButton(
                imageVector = if (expanded) {
                    Icons.Filled.Close
                } else {
                    Icons.Filled.Menu
                },
                contentDescription = if (expanded) {
                    CLOSE_MENU_CONTENT_DESCRIPTION
                } else {
                    OPEN_MENU_CONTENT_DESCRIPTION
                },
                onClick = onMenuButtonClick,
                onPressAndRelease = {
                    menuButtonVisible = false
                    onMenuButtonRelease()
                }
            )
        }
    }
}

private const val OPEN_MENU_CONTENT_DESCRIPTION = "Open menu button"
private const val CLOSE_MENU_CONTENT_DESCRIPTION = "Close menu button"
