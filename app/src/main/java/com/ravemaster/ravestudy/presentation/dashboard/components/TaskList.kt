package com.ravemaster.ravestudy.presentation.dashboard.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.ravemaster.ravestudy.R
import com.ravemaster.ravestudy.domain.models.Task

fun LazyListScope.taskList(
    sectionTitle: String,
    taskList: List<Task>
){
    item {
        Text(
            text = sectionTitle,
            modifier = Modifier.padding(12.dp),
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(16.dp))
    }
    if (taskList.isEmpty()){
        item {
            Column (
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Image(
                    modifier = Modifier
                        .size(120.dp),
                    painter = painterResource(R.drawable.microtask_svgrepo_com),
                    contentDescription = "Empty subject list"
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    "You have no upcoming tasks, click the '+' icon to create subjects first",
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.padding( 12.dp),
                    textAlign = TextAlign.Center
                )

            }
        }
    }
    items(taskList){
        task->
        TaskCard(
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp),
            task = task,
            onCheckBoxClicked = {},
            onClicked = {}
        )

    }

}