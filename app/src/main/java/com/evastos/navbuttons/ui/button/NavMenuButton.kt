package com.evastos.navbuttons.ui.button

import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.awaitEachGesture
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.awaitLongPressOrCancellation
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.pointerInput
import com.evastos.navbuttons.ui.theme.ButtonPadding

@Composable
fun NavMenuButton(
    modifier: Modifier = Modifier,
    imageVector: ImageVector,
    contentDescription: String,
    onClick: () -> Unit,
    onLongPressRelease: () -> Unit
) {
    FloatingActionButton(
        modifier = modifier
            .pointerInput(Unit) {
                awaitEachGesture {
                    awaitFirstDown(requireUnconsumed = false).also { change ->
                        change.consume()
                        awaitLongPressOrCancellation(change.id)?.run {
                            onLongPressRelease()
                        }
                    }
                }
            }
            .clickable {
                onClick()
            }
            .padding(all = ButtonPadding),
        shape = CircleShape,
        onClick = onClick
    ) {
        Icon(
            modifier = Modifier,
            imageVector = imageVector,
            contentDescription = contentDescription
        )
    }
}
