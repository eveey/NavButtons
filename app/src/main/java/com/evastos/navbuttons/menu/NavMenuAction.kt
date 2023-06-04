package com.evastos.navbuttons.menu

sealed interface NavMenuAction

object NavActionStake : NavMenuAction
object NavActionSend : NavMenuAction
object NavActionReceive : NavMenuAction
object NavActionSupply : NavMenuAction
object NavActionBorrow : NavMenuAction

val navMenuActions = arrayListOf(
    NavActionStake,
    NavActionSend,
    NavActionReceive,
    NavActionSupply,
    NavActionBorrow
)
