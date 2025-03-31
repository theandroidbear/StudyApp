package com.ravemaster.ravestudy.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun RadioButtonComp(themeMode: MutableState<String>) {
    val themes = listOf("light","dark","mediumContrastLight","mediumContrastDark","highContrastLight","highContrastDark")
    var selectedTheme by remember {
        mutableStateOf(themes[0])
    }
    Column{
        themes.forEach { theme ->
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .selectable(
                        selected = selectedTheme == theme,
                        onClick = {
                            selectedTheme = theme
                            themeMode.value = theme
                        }
                    )
                    .padding(horizontal = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Text(
                    text = theme,
                    modifier = Modifier.padding(start = 8.dp)
                )
                RadioButton(
                    selected = selectedTheme == theme,
                    onClick = null,
                    modifier = Modifier.padding(start = 8.dp)
                )

            }
        }
    }
}