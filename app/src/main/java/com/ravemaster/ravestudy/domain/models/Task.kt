package com.ravemaster.ravestudy.domain.models

data class Task(
    val name: String,
    val description: String,
    val dueDate: Long,
    val priority: Int,
    val relatedToSubject: String,
    val isComplete: Boolean
)