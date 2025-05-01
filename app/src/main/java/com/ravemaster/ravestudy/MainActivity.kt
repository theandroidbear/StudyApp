package com.ravemaster.ravestudy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.ravemaster.ravestudy.presentation.dashboard.DashboardScreen
import com.ravemaster.ravestudy.presentation.theme.JetpackBaseProjectTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackBaseProjectTheme() {
                DashboardScreen()
            }
        }
    }
}