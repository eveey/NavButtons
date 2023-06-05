package com.evastos.navbuttons.ui.button

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import com.evastos.navbuttons.ui.theme.ButtonPadding

@Composable
fun NavMenuActionButton(
    modifier: Modifier = Modifier,
    imageVector: ImageVector,
    contentDescription: String,
    onClick: () -> Unit
) {

//    val sizeScale by animateFloatAsState(if (isPressedOrDragged) 2f else 1f)

    SmallFloatingActionButton(
        modifier = modifier
            .graphicsLayer(
                scaleX = 1f,
                scaleY = 1f
            )
            .padding(all = ButtonPadding),
        shape = CircleShape,
        onClick = onClick
    ) {
        Icon(
            imageVector = imageVector,
            contentDescription = contentDescription
        )
    }
}
