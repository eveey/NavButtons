package com.evastos.navbuttons.ui.scaffold

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.evastos.navbuttons.R
import com.evastos.navbuttons.ui.theme.BackgroundBlur
import com.evastos.navbuttons.ui.theme.NoBlur

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavButtonsScaffold(
    title: String,
    modifier: Modifier = Modifier,
    menuExpanded: Boolean,
    navMenuButton: @Composable () -> Unit,
    content: @Composable () -> Unit
) {
    val backgroundBlur by animateDpAsState(
        if (menuExpanded) {
            BackgroundBlur
        } else {
            NoBlur
        },
        animationSpec = tween()
    )

    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                modifier = modifier
                    .systemBarsPadding()
                    .blur(backgroundBlur),
                colors = topAppBarColors(
                    containerColor = Color.Transparent
                ),
                title = {
                    Text(
                        text = title
                    )
                }
            )
        },
        floatingActionButton = navMenuButton,
        floatingActionButtonPosition = FabPosition.Center
    ) { padding ->
        Column(
            modifier = modifier
                .blur(backgroundBlur)
        ) {
            Image(
                modifier = Modifier
                    .fillMaxSize(),
                painter = painterResource(id = R.drawable.main_bg),
                contentScale = ContentScale.Crop,
                contentDescription = "Background image"
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
            ) {
                content()
            }
        }
    }
}
