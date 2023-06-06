package com.evastos.navbuttons.navigation

sealed interface NavDestination {
    val route: String
}

object MenuDestination : NavDestination {
    override val route = "menu"
}

object StakeDestination : NavDestination {
    override val route = "menu/stake"
}

object SendDestination : NavDestination {
    override val route = "menu/send"
}

object ReceiveDestination : NavDestination {
    override val route = "menu/receive"
}

object SupplyDestination : NavDestination {
    override val route = "menu/supply"
}

object BorrowDestination : NavDestination {
    override val route = "menu/borrow"
}
