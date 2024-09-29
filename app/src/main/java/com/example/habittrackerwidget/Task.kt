package com.example.habitrackerwidget

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "task_table")
data class Task(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val taskName: String,
    val taskTime: Long, // Unix Timestamp
    var isChecked: Boolean = false
)
