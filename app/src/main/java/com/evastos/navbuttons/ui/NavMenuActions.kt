package com.evastos.navbuttons.ui

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.vector.ImageVector
import com.evastos.navbuttons.R
import com.evastos.navbuttons.navigation.BorrowDestination
import com.evastos.navbuttons.navigation.NavRouter
import com.evastos.navbuttons.navigation.ReceiveDestination
import com.evastos.navbuttons.navigation.SendDestination
import com.evastos.navbuttons.navigation.StakeDestination
import com.evastos.navbuttons.navigation.SupplyDestination
import com.evastos.navbuttons.ui.animation.Animatable

@Stable
sealed interface NavMenuAction : NavRouter, Animatable {
    @get:StringRes
    val action: Int
    val icon: ImageVector
}

object StakeNavMenuAction : NavMenuAction {
    override val action = R.string.menu_action_stake
    override val icon = Icons.Filled.Person
    override val navDestination = StakeDestination
}

object SendNavMenuAction : NavMenuAction {
    override val action = R.string.menu_action_send
    override val icon = Icons.Filled.Send
    override val navDestination = SendDestination
}

object ReceiveNavMenuAction : NavMenuAction {
    override val action = R.string.menu_action_receive
    override val icon = Icons.Filled.Create
    override val navDestination = ReceiveDestination
}

object SupplyNavMenuAction : NavMenuAction {
    override val action = R.string.menu_action_supply
    override val icon = Icons.Filled.AddCircle
    override val navDestination = SupplyDestination
}

object BorrowNavMenuAction : NavMenuAction {
    override val action = R.string.menu_action_borrow
    override val icon = Icons.Filled.Share
    override val navDestination = BorrowDestination
}

val NavMenuActions = arrayListOf<NavMenuAction>(
    StakeNavMenuAction,
    SendNavMenuAction,
    ReceiveNavMenuAction,
    SupplyNavMenuAction,
    BorrowNavMenuAction
)

val animatableList = NavMenuActions as List<Animatable>
