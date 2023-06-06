package com.evastos.navbuttons.ui.animation

import androidx.compose.animation.core.Spring.DampingRatioMediumBouncy
import androidx.compose.animation.core.Spring.StiffnessMediumLow
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
                dampingRatio = DampingRatioMediumBouncy,
                stiffness = StiffnessMediumLow
            )
        }
    )

    if (baseOffset.isSpecified.not()) {
        return
    }

    val middleIndex = animatables.size / 2

    animatables.forEachIndexed { index, animatable ->
        (index - middleIndex).run {
            val xOffset = (baseOffset * this).value * VELOCITY_X
            val yOffset = if (this == 0) {
                baseOffset.value.unaryMinus() * (OFFSET_SCALE + 1.1 * VELOCITY_Y)
            } else {
                baseOffset.value.unaryMinus() * (OFFSET_SCALE + VELOCITY_Y / absoluteValue)
            }
            DpOffset(
                x = xOffset.dp, y = yOffset.dp
            )
        }.run {
            animateComposable(
                this, animatable
            )
        }
    }
}

private const val OFFSET_SCALE = 0.1
private const val VELOCITY_X = 0.4
private const val VELOCITY_Y = 0.3