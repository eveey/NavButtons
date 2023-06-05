package com.evastos.navbuttons.ui.screen.menu

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.evastos.navbuttons.R

@Composable
fun NavButtonsMenuScreen(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize(),
    ) {
        Image(
            modifier = Modifier
                .fillMaxSize(),
            painter = painterResource(id = R.drawable.nav_buttons_menu_background),
            contentScale = ContentScale.Crop,
            contentDescription = "Menu background image",
        )
    }
}
