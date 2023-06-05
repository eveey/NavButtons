package com.evastos.navbuttons.ui.screen.menu.action

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.evastos.navbuttons.ui.theme.ContentColor
import com.evastos.navbuttons.ui.theme.RegularTextSize

@Composable
fun NavButtonsMenuActionText(
    modifier: Modifier = Modifier,
    action: String
) {
    Text(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        color = ContentColor,
        fontSize = RegularTextSize,
        text = action,
        textAlign = TextAlign.Center
    )
}
