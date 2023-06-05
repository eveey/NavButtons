package com.evastos.navbuttons.ui.screen.menu.action

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Share
import androidx.compose.ui.graphics.vector.ImageVector
import com.evastos.navbuttons.R

sealed class NavButtonsMenuAction(
    @StringRes val action: Int,
    val icon: ImageVector,
)

object StakeMenuAction : NavButtonsMenuAction(
    action = R.string.menu_action_stake,
    icon = Icons.Filled.Menu,
)

object SendMenuAction : NavButtonsMenuAction(
    action = R.string.menu_action_send,
    icon = Icons.Filled.Send,
)

object ReceiveMenuAction : NavButtonsMenuAction(
    action = R.string.menu_action_receive,
    icon = Icons.Filled.Create,
)

object SupplyMenuAction : NavButtonsMenuAction(
    action = R.string.menu_action_supply,
    icon = Icons.Filled.AddCircle,
)

object BorrowMenuAction : NavButtonsMenuAction(
    action = R.string.menu_action_borrow,
    icon = Icons.Filled.Share,
)

val NavButtonsMenuActions = arrayListOf(
    StakeMenuAction,
    SendMenuAction,
    ReceiveMenuAction,
    SupplyMenuAction,
    BorrowMenuAction,
)
