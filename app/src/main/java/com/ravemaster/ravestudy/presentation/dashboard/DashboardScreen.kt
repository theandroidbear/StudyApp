package com.ravemaster.ravestudy.presentation.dashboard

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.ravemaster.ravestudy.R
import com.ravemaster.ravestudy.domain.models.Subject
import com.ravemaster.ravestudy.presentation.dashboard.components.CountCard
import com.ravemaster.ravestudy.presentation.dashboard.components.DashboardScreenTopBar
import com.ravemaster.ravestudy.presentation.dashboard.components.SubjectCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(modifier: Modifier = Modifier) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())
    val subjects = listOf(
        Subject(
            name = "English",
            goalHours = 6.0f,
            colors = Subject.subjectCardColors[0]
        ),
        Subject(
            name = "Mathematics",
            goalHours = 6.0f,
            colors = Subject.subjectCardColors[1]
        ),
        Subject(
            name = "Physics",
            goalHours = 6.0f,
            colors = Subject.subjectCardColors[2]
        ),
        Subject(
            name = "Fine Arts",
            goalHours = 6.0f,
            colors = Subject.subjectCardColors[3]
        ),
        Subject(
            name = "Music",
            goalHours = 6.0f,
            colors = Subject.subjectCardColors[4]
        )
    )
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
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    subjectCount = 3,
                    studyHours = "4",
                    goalHours = "5"

                )
            }
            item {
                SubjectsCardSection(
                    subjectList = subjects
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

@Composable
private fun SubjectsCardSection(
    modifier: Modifier = Modifier,
    subjectList: List<Subject>
) {
    val context = LocalContext.current
    Column (
        modifier = modifier
    ){
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                "Subjects",
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(start = 12.dp),
                fontWeight = FontWeight.Bold
            )

            IconButton(
                onClick = {
                    Toast.makeText(context,"to be added",Toast.LENGTH_LONG).show()
                }
            ) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "Add subject icon"
                )
            }

        }
        if (subjectList.isEmpty()){
            Image(
                modifier = Modifier
                    .size(120.dp)
                    .align(Alignment.CenterHorizontally),
                painter = painterResource(R.drawable.books_svgrepo_com),
                contentDescription = "Empty subject list"
            )
            Text(
                "You have no subjects available, click the '+' icon to add",
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.padding( 12.dp),
                textAlign = TextAlign.Center
            )
        }
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(start = 12.dp, end = 12.dp)
        ) {
            items(subjectList){
                subject ->
                SubjectCard(
                    subjectName = subject.name,
                    gradientColors = subject.colors,
                    onClick = {
                        Toast.makeText(context,subject.name,Toast.LENGTH_LONG).show()
                    }
                )
            }
        }
    }
}