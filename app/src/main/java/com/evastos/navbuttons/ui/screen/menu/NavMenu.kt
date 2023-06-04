@file:OptIn(ExperimentalAnimationApi::class)

package com.evastos.navbuttons.ui.surface

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.evastos.navbuttons.ui.animated.fadeThrough
import com.evastos.navbuttons.ui.button.NavMenuButton
import com.evastos.navbuttons.ui.scaffold.NavButtonsScaffold

//@OptIn(ExperimentalAnimationApi::class)
//@Composable
//fun NavActionMenu(
//) {
//    var expanded by rememberSaveable { mutableStateOf(false) }
//
//    AnimatedContent(
//        targetState = expanded,
//        transitionSpec = fadeThrough()
//    ) { navExpanded ->
//        NavButtonsScaffold(
//            modifier = Modifier
//                .fillMaxSize(),
//            title = "Meld",
//            navButton = {
//                NavMenuButton(
//                    onClick = { expanded = !expanded },
//                )
//            }
//        ) {
//
//        }
//    }
//}
