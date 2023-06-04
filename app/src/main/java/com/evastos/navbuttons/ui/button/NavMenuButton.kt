package com.evastos.navbuttons.ui.button

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.evastos.navbuttons.ui.screen.NavMenuButtonState
import com.evastos.navbuttons.ui.theme.ButtonPadding

@Composable
fun NavMenuButton(
    navMenuButtonState: NavMenuButtonState,
    onClick: () -> Unit
) {
    Crossfade(
        targetState = navMenuButtonState,
        animationSpec = tween()
    ) { state ->
        FloatingActionButton(
            modifier = Modifier
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
