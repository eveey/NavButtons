package com.evastos.navbuttons.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.evastos.navbuttons.ui.BorrowNavMenuAction
import com.evastos.navbuttons.ui.ReceiveNavMenuAction
import com.evastos.navbuttons.ui.SendNavMenuAction
import com.evastos.navbuttons.ui.StakeNavMenuAction
import com.evastos.navbuttons.ui.SupplyNavMenuAction
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
                action = stringResource(id = StakeNavMenuAction.action)
            )
        }
        composable(
            route = SendDestination.route
        ) {
            NavButtonsMenuActionText(
                action = stringResource(id = SendNavMenuAction.action)
            )
        }
        composable(
            route = ReceiveDestination.route
        ) {
            NavButtonsMenuActionText(
                action = stringResource(id = ReceiveNavMenuAction.action)
            )
        }
        composable(
            route = SupplyDestination.route
        ) {
            NavButtonsMenuActionText(
                action = stringResource(id = SupplyNavMenuAction.action)
            )
        }
        composable(
            route = BorrowDestination.route
        ) {
            NavButtonsMenuActionText(
                action = stringResource(id = BorrowNavMenuAction.action)
            )
        }
    }
}
