package com.evastos.navbuttons.navigation

sealed class NavButtonsDestination(
    val route: String,
)

object MenuDestination : NavButtonsDestination(
    route = "menu",
)

object StakeDestination : NavButtonsDestination(
    route = "menu/stake",
)

object SendDestination : NavButtonsDestination(
    route = "menu/send",
)

object ReceiveDestination : NavButtonsDestination(
    route = "menu/receive",
)

object SupplyDestination : NavButtonsDestination(
    route = "menu/supply",
)

object BorrowDestination : NavButtonsDestination(
    route = "menu/borrow",
)
