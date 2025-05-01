package com.ravemaster.ravestudy.presentation.dashboard

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import com.ravemaster.ravestudy.presentation.dashboard.components.CountCard
import com.ravemaster.ravestudy.presentation.dashboard.components.DashboardScreenTopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(modifier: Modifier = Modifier) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())
    Scaffold (
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            DashboardScreenTopBar(scrollBehavior = scrollBehavior)
        }
    ){ paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            item {
                CardSection(
                    modifier = Modifier.fillMaxWidth().padding(12.dp),
                    subjectCount = 3,
                    studyHours = "4",
                    goalHours = "5"

                )
            }
        }

    }
}

@Composable
private fun CardSection(
    modifier: Modifier,
    subjectCount: Int,
    studyHours: String,
    goalHours: String
) {
    Row (
        modifier = modifier
    ){
        CountCard(
            text = "Subject Count",
            count = "$subjectCount",
            modifier = Modifier.weight(1f)
        )
        Spacer(modifier = Modifier.width(10.dp))
        CountCard(
            modifier = Modifier.weight(1f),
            text = "Studied Hours",
            count = studyHours,
        )
        Spacer(modifier = Modifier.width(10.dp))
        CountCard(
            modifier = Modifier.weight(1f),
            text = "Goal Study Hours",
            count = goalHours,
        )
    }
}