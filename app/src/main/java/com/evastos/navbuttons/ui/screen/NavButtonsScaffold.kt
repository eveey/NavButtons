package com.evastos.navbuttons.ui.screen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavButtonsScaffold(
    title: String,
    modifier: Modifier = Modifier,
    backgroundBlur: Dp,
    navMenuButton: @Composable () -> Unit,
    content: @Composable (PaddingValues) -> Unit,
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                modifier = modifier
                    .systemBarsPadding()
                    .blur(backgroundBlur),
                colors = topAppBarColors(
                    containerColor = Color.Transparent,
                ),
                title = {
                    Text(text = title)
                },
            )
        },
        floatingActionButton = navMenuButton,
        floatingActionButtonPosition = FabPosition.Center,
    ) { paddingValues ->
        content(paddingValues)
    }
}
