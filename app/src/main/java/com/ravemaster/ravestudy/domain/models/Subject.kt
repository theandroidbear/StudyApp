package com.ravemaster.ravestudy.domain.models

import androidx.compose.ui.graphics.Color
import com.ravemaster.ravestudy.presentation.theme.blueGradient
import com.ravemaster.ravestudy.presentation.theme.greenGradient
import com.ravemaster.ravestudy.presentation.theme.purpleGradient
import com.ravemaster.ravestudy.presentation.theme.redGradient
import com.ravemaster.ravestudy.presentation.theme.yellowGradient

data class Subject(
    val name: String,
    val goalHours: Float,
    val colors: List<Color>
){
    companion object{
        val subjectCardColors = listOf(redGradient, blueGradient, greenGradient, yellowGradient, purpleGradient)
    }
}
