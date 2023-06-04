package com.evastos.navbuttons.ui.button

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.evastos.navbuttons.ui.animated.AnimationConstants.LongDurationMillis
import com.evastos.navbuttons.ui.screen.NavMenuButtonState
import com.evastos.navbuttons.ui.theme.ButtonPadding

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun NavMenuButton(
    navMenuButtonState: NavMenuButtonState,
    onClick: () -> Unit
) {
    Crossfade(
        targetState = navMenuButtonState,
        animationSpec = tween(durationMillis = LongDurationMillis)
    ) { state ->
        FloatingActionButton(
            modifier = Modifier
                .combinedClickable(
                    onClick = { },
                    onLongClick = { },
                )
                .padding(all = ButtonPadding),
            shape = CircleShape,
            onClick = onClick
        ) {
            Icon(
                imageVector = state.imageVector,
                contentDescription = state.contentDescription
            )
        }
    }
}
