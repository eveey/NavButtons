package com.evastos.navbuttons.ui.animation

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.Transition
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.spring
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.isSpecified
import kotlin.math.absoluteValue

@Composable
fun <A : Animatable> AnimatedExplosion(
    transition: Transition<Boolean>,
    animatables: List<A>,
    animatableSize: Dp,
    animateComposable: @Composable (DpOffset, A) -> Unit
) {
    val baseOffset by transition.animateDp(
        targetValueByState = { animate ->
            if (animate) {
                animatableSize
            } else {
                Dp.Hairline
            }
        },
        label = "explosion animation",
        transitionSpec = {
            spring(
                dampingRatio = Spring.DampingRatioMediumBouncy,
                stiffness = Spring.StiffnessMediumLow
            )
        }
    )

    if (baseOffset.isSpecified) {
        val middleIndex = animatables.size / 2

        animatables.forEachIndexed { index, animatable ->
            val relativeToMiddle = index - middleIndex
            val xOffset = (baseOffset * relativeToMiddle).value * VELOCITY_X
            val yOffset = if (relativeToMiddle == 0) {
                -((0.1 + 1.1 * VELOCITY_Y) * baseOffset.value)
            } else {
                -((0.1 + VELOCITY_Y / relativeToMiddle.absoluteValue) * baseOffset.value)
            }

            animateComposable(
                DpOffset(
                    x = xOffset.dp,
                    y = yOffset.dp
                ),
                animatable
            )
        }
    }
}

private const val VELOCITY_X = 0.4
private const val VELOCITY_Y = 0.3
