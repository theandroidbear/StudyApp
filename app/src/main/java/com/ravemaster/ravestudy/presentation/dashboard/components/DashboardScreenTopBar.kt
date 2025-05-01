package com.ravemaster.ravestudy.presentation.dashboard.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.lerp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreenTopBar(modifier: Modifier = Modifier, scrollBehavior: TopAppBarScrollBehavior?) {
    MediumTopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.surface,
            scrolledContainerColor = MaterialTheme.colorScheme.surface,
            titleContentColor = MaterialTheme.colorScheme.onSurface
        ),
       title = {
           // Get the collapsed fraction (0.0f = fully expanded, 1.0f = fully collapsed)
           val collapsedFraction = scrollBehavior?.state?.collapsedFraction ?: 0f
           // Define text sizes
           val largeTextSize = 26.sp// Size when not scrolled (expanded)
           val smallTextSize = 22.sp // Size when scrolled (collapsed)
           // Interpolate between large and small text sizes
           val textSize = lerp(largeTextSize, smallTextSize, collapsedFraction)
           Text(
               "RaveStudy",
               maxLines = 1,
               overflow = TextOverflow.Ellipsis,
               fontWeight = FontWeight.Bold,
               fontSize = textSize,
               color = MaterialTheme.colorScheme.primary
           )
       },
        actions = {
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Filled.MoreVert,
                    contentDescription = "More menu"
                )
            }
        },
        scrollBehavior = scrollBehavior
   )
}