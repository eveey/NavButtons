package com.evastos.navbuttons.ui.button

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextMeasurer
import androidx.compose.ui.text.rememberTextMeasurer
import com.evastos.navbuttons.extension.drawTopText
import com.evastos.navbuttons.ui.theme.MinFabSize
import com.evastos.navbuttons.ui.theme.SmallFabSize

@OptIn(ExperimentalTextApi::class)
@Composable
fun NavMenuActionButton(
    modifier: Modifier = Modifier,
    imageVector: ImageVector,
    menuExpanded: Boolean,
    action: String,
    onClick: () -> Unit,
    textMeasurer: TextMeasurer = rememberTextMeasurer()
) {
    Box(
        modifier = modifier
            .sizeIn(
                minWidth = MinFabSize,
                minHeight = MinFabSize
            ),
        contentAlignment = Alignment.Center
    ) {
        SmallFloatingActionButton(
            modifier = modifier
                .size(SmallFabSize)
                .align(Alignment.Center)
                .drawTopText(
                    textMeasurer = textMeasurer,
                    text = action,
                    enabled = menuExpanded
                )
                .clickable {
                    onClick()
                },
            shape = CircleShape,
            onClick = onClick
        ) {
            Icon(
                imageVector = imageVector,
                contentDescription = action
            )
        }
    }
}


