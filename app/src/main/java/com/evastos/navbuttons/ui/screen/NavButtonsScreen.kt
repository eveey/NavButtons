package com.evastos.navbuttons.ui.screen

import androidx.activity.compose.BackHandler
import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.Spring.DampingRatioLowBouncy
import androidx.compose.animation.core.Spring.StiffnessMediumLow
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.isSpecified
import com.evastos.navbuttons.R
import com.evastos.navbuttons.navigation.NavButtonsAppState
import com.evastos.navbuttons.navigation.NavButtonsNavHost
import com.evastos.navbuttons.navigation.rememberNavButtonsAppState
import com.evastos.navbuttons.ui.MenuAction
import com.evastos.navbuttons.ui.MenuActions
import com.evastos.navbuttons.ui.button.NavMenuActionButton
import com.evastos.navbuttons.ui.button.NavMenuButton
import com.evastos.navbuttons.ui.theme.BackgroundBlur
import com.evastos.navbuttons.ui.theme.NoBlur
import com.evastos.navbuttons.ui.theme.RegularSpacing
import com.evastos.navbuttons.ui.theme.SmallFabSize
import kotlin.math.absoluteValue

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

    val menuButtonsOffset by menuTransition.animateDp(
        targetValueByState = { isMenuExpanded ->
            if (isMenuExpanded) {
                SmallFabSize + RegularSpacing
            } else {
                Dp.Hairline
            }
        },
        label = "menu buttons offset",
        transitionSpec = {
            spring(
                dampingRatio = DampingRatioLowBouncy,
                stiffness = StiffnessMediumLow
            )
        }
    )

    val backgroundBlur by menuTransition.animateDp(
        targetValueByState = { isMenuExpanded ->
            if (isMenuExpanded) {
                BackgroundBlur
            } else {
                NoBlur
            }
        },
        label = "menu expanded, background blur",
        transitionSpec = { tween() }
    )

    NavButtonsScaffold(
        modifier = Modifier,
        title = stringResource(id = R.string.app_name),
        navMenuButton = {
            NavButtonsMenu(
                menuExpanded = menuExpanded,
                menuButtonsOffset = menuButtonsOffset,
                onMenuButtonClick = {
                    menuExpanded = !menuExpanded
                },
                onMenuButtonRelease = {
                    menuExpanded = true
                },
                onMenuActionClick = { menuAction ->
                    menuExpanded = false
                    appState.navigateToDestination(menuAction.destination)
                }
            )
        },
        backgroundBlur = backgroundBlur
    ) { _ ->
        NavButtonsNavHost(
            appState = appState
        )
    }
}

@Composable
fun NavButtonsMenu(
    menuExpanded: Boolean,
    menuButtonsOffset: Dp,
    onMenuButtonClick: () -> Unit,
    onMenuButtonRelease: () -> Unit,
    onMenuActionClick: (MenuAction) -> Unit
) {
    var menuButtonVisible by rememberSaveable { mutableStateOf(true) }

    if (menuButtonsOffset.isSpecified) {
        MenuActions.forEachIndexed { index, menuAction ->
            val relativeToMiddle = index - menuButtonsMiddleIndex
            val xOffset = (menuButtonsOffset * relativeToMiddle).value * xFactor
            val yOffset = if (relativeToMiddle == 0) {
                -((1 + 1.1 * yFactor) * menuButtonsOffset.value)
            } else {
                -((1 + yFactor / relativeToMiddle.absoluteValue) * menuButtonsOffset.value)
            }
            NavMenuActionButton(
                modifier = Modifier
                    .offset(
                        x = xOffset.dp,
                        y = yOffset.dp
                    ),
                imageVector = menuAction.icon,
                contentDescription = stringResource(id = menuAction.action),
                onClick = {
                    menuButtonVisible = true
                    onMenuActionClick(menuAction)
                }
            )
        }
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
                    "Close menu button"
                } else {
                    "Open menu button"
                },
                onClick = onMenuButtonClick,
                onLongPressRelease = {
                    menuButtonVisible = false
                    onMenuButtonRelease()
                }
            )
        }
    }
}

private val menuButtonsMiddleIndex = MenuActions.size / 2

private const val xFactor = 1.1
private const val yFactor = 0.4
