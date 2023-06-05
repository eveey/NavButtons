package com.evastos.navbuttons.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.evastos.navbuttons.ui.BorrowMenuAction
import com.evastos.navbuttons.ui.ReceiveMenuAction
import com.evastos.navbuttons.ui.SendMenuAction
import com.evastos.navbuttons.ui.StakeMenuAction
import com.evastos.navbuttons.ui.SupplyMenuAction
import com.evastos.navbuttons.ui.screen.menu.action.NavButtonsMenuActionText

@Composable
fun NavButtonsNavHost(
    appState: NavButtonsAppState,
    startDestination: String = MenuDestination.route
) {
    val navController = appState.navController

    NavHost(
        navController = navController,
        startDestination = startDestination,
    ) {
        composable(
            route = MenuDestination.route
        ) { }
        composable(
            route = StakeDestination.route
        ) {
            NavButtonsMenuActionText(
                action = stringResource(id = StakeMenuAction.action)
            )
        }
        composable(
            route = SendDestination.route
        ) {
            NavButtonsMenuActionText(
                action = stringResource(id = SendMenuAction.action)
            )
        }
        composable(
            route = ReceiveDestination.route
        ) {
            NavButtonsMenuActionText(
                action = stringResource(id = ReceiveMenuAction.action)
            )
        }
        composable(
            route = SupplyDestination.route
        ) {
            NavButtonsMenuActionText(
                action = stringResource(id = SupplyMenuAction.action)
            )
        }
        composable(
            route = BorrowDestination.route
        ) {
            NavButtonsMenuActionText(
                action = stringResource(id = BorrowMenuAction.action)
            )
        }
    }
}
