package com.evastos.navbuttons.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions

@Composable
fun rememberNavButtonsAppState(
    navController: NavHostController = rememberNavController()
) = remember(navController) {
    NavButtonsAppState(navController)
}

@Stable
class NavButtonsAppState(
    val navController: NavHostController
) {
    fun navigateToDestination(
        navRouter: NavRouter
    ) = navOptions {
        // Pop up to the start destination of the graph to
        // avoid building up a large stack of destinations
        // on the back stack as users select items
        popUpTo(navController.graph.findStartDestination().id) {
            saveState = true
        }
        // Avoid multiple copies of the same destination when
        // re-selecting the same item
        launchSingleTop = true
        // Restore state when re-selecting a previously selected item
        restoreState = true
    }.run {
        navController.navigate(navRouter.navDestination.route, this)
    }
}
