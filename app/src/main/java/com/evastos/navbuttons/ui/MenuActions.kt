package com.evastos.navbuttons.ui

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.vector.ImageVector
import com.evastos.navbuttons.R
import com.evastos.navbuttons.navigation.BorrowDestination
import com.evastos.navbuttons.navigation.NavButtonsDestination
import com.evastos.navbuttons.navigation.ReceiveDestination
import com.evastos.navbuttons.navigation.SendDestination
import com.evastos.navbuttons.navigation.StakeDestination
import com.evastos.navbuttons.navigation.SupplyDestination

@Stable
sealed class MenuAction(
    @StringRes val action: Int,
    val icon: ImageVector,
    val destination: NavButtonsDestination
)

object StakeMenuAction : MenuAction(
    action = R.string.menu_action_stake,
    icon = Icons.Filled.Person,
    destination = StakeDestination
)

object SendMenuAction : MenuAction(
    action = R.string.menu_action_send,
    icon = Icons.Filled.Send,
    destination = SendDestination
)

object ReceiveMenuAction : MenuAction(
    action = R.string.menu_action_receive,
    icon = Icons.Filled.Create,
    destination = ReceiveDestination
)

object SupplyMenuAction : MenuAction(
    action = R.string.menu_action_supply,
    icon = Icons.Filled.AddCircle,
    destination = SupplyDestination
)

object BorrowMenuAction : MenuAction(
    action = R.string.menu_action_borrow,
    icon = Icons.Filled.Share,
    destination = BorrowDestination
)

val MenuActions = arrayListOf(
    StakeMenuAction,
    SendMenuAction,
    ReceiveMenuAction,
    SupplyMenuAction,
    BorrowMenuAction
)
