package com.evastos.navbuttons.extension

import androidx.compose.foundation.gestures.awaitEachGesture
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.awaitLongPressOrCancellation
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextMeasurer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.toSize
import com.evastos.navbuttons.ui.theme.ContentColor
import com.evastos.navbuttons.ui.theme.SmallSpacing
import com.evastos.navbuttons.ui.theme.SmallTextSize
import kotlin.math.min

fun Modifier.pressedAndReleased(
    callback: () -> Unit
) = pointerInput(Unit) {
    awaitEachGesture {
        awaitFirstDown(requireUnconsumed = false).also { change ->
            change.consume()
            awaitLongPressOrCancellation(change.id)?.run {
                callback()
            }
        }
    }
}

@OptIn(ExperimentalTextApi::class)
fun Modifier.drawTopText(
    textMeasurer: TextMeasurer,
    text: String,
    enabled: Boolean = true
) = drawBehind {
    if (enabled) {
        TextStyle(
            textAlign = TextAlign.Center,
            fontSize = SmallTextSize,
            color = ContentColor
        ).let { textStyle ->
            textMeasurer.measure(
                text = text,
                style = textStyle,
                maxLines = 1,
                softWrap = false,
                overflow = TextOverflow.Visible
            ).run {
                drawText(
                    textMeasurer = textMeasurer,
                    text = text,
                    size = size.toSize(),
                    style = textStyle,
                    topLeft = Offset(
                        x = min(0f, 2 * center.x - getHorizontalPosition(0, true) - size.width),
                        y = (size.height + SmallSpacing.toPx()).unaryMinus()
                    ),
                    maxLines = 1,
                    softWrap = false,
                    overflow = TextOverflow.Visible
                )
            }
        }
    }
}
