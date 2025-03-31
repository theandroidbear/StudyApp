package com.ravemaster.ravestudy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ravemaster.ravestudy.components.RadioButtonComp
import com.ravemaster.ravestudy.ui.theme.JetpackBaseProjectTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val themeMode = remember {
                mutableStateOf("light")
            }
            JetpackBaseProjectTheme(themeMode = themeMode.value) {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(modifier = Modifier.padding(innerPadding), themeMode)
                }
            }
        }
    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier, themeMode: MutableState<String>) {
    Column (
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ){
        RadioButtonComp(themeMode = themeMode)
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackBaseProjectTheme {
    }
}