package com.evastos.navbuttons.ui.screen.menu.action

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign

@Composable
fun NavButtonsActionScreen(
    modifier: Modifier = Modifier,
    navButtonsMenuAction: NavButtonsMenuAction,
) {
    Box(
        modifier = modifier
            .background(color = colorScheme.inversePrimary)
            .fillMaxSize(),
    ) {
        Text(
            modifier = modifier
                .align(Alignment.Center),
            text = stringResource(id = navButtonsMenuAction.action),
            textAlign = TextAlign.Center,
        )
    }
}
