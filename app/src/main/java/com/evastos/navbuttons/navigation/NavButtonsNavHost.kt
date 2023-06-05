package com.evastos.navbuttons.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.evastos.navbuttons.ui.screen.menu.NavButtonsMenuScreen
import com.evastos.navbuttons.ui.screen.menu.action.BorrowMenuAction
import com.evastos.navbuttons.ui.screen.menu.action.NavButtonsActionScreen
import com.evastos.navbuttons.ui.screen.menu.action.ReceiveMenuAction
import com.evastos.navbuttons.ui.screen.menu.action.SendMenuAction
import com.evastos.navbuttons.ui.screen.menu.action.StakeMenuAction
import com.evastos.navbuttons.ui.screen.menu.action.SupplyMenuAction

@Composable
fun NavButtonsNavHost(
    appState: NavButtonsAppState,
    modifier: Modifier = Modifier,
    paddingValues: PaddingValues,
    startDestination: String = MenuDestination.route,
) {
    val navController = appState.navController
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
    ) {
        composable(route = MenuDestination.route) {
            NavButtonsMenuScreen(
                modifier = modifier,
            )
        }
        composable(route = StakeDestination.route) {
            NavButtonsActionScreen(
                modifier = modifier.padding(paddingValues),
                navButtonsMenuAction = StakeMenuAction,
            )
        }
        composable(route = SendDestination.route) {
            NavButtonsActionScreen(
                modifier = modifier.padding(paddingValues),
                navButtonsMenuAction = SendMenuAction,
            )
        }
        composable(route = ReceiveDestination.route) {
            NavButtonsActionScreen(
                modifier = modifier.padding(paddingValues),
                navButtonsMenuAction = ReceiveMenuAction,
            )
        }
        composable(route = SupplyDestination.route) {
            NavButtonsActionScreen(
                modifier = modifier.padding(paddingValues),
                navButtonsMenuAction = SupplyMenuAction,
            )
        }
        composable(route = BorrowDestination.route) {
            NavButtonsActionScreen(
                modifier = modifier.padding(paddingValues),
                navButtonsMenuAction = BorrowMenuAction,
            )
        }
    }
}
