package com.evastos.navbuttons.ui.button

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import com.evastos.navbuttons.extension.pressedAndReleased
import com.evastos.navbuttons.ui.theme.MinFabSize

@Composable
fun NavMenuButton(
    modifier: Modifier = Modifier,
    imageVector: ImageVector,
    contentDescription: String,
    onClick: () -> Unit,
    onPressAndRelease: () -> Unit
) {
    Box(
        modifier = modifier
            .sizeIn(
                minWidth = MinFabSize,
                minHeight = MinFabSize
            ),
        contentAlignment = Alignment.Center
    ) {
        FloatingActionButton(
            modifier = modifier
                .align(Alignment.Center)
                .pressedAndReleased {
                    onPressAndRelease()
                }
                .clickable {
                    onClick()
                },
            shape = CircleShape,
            onClick = onClick
        ) {
            Icon(
                imageVector = imageVector,
                contentDescription = contentDescription
            )
        }
    }
}
