package com.example.habitrackerwidget

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TaskDao {
    @Insert
    suspend fun insert(task: Task)

    @Query("SELECT * FROM task_table WHERE date(taskTime) = date('now')")
    suspend fun getTodaysTasks(): List<Task>

    @Query("DELETE FROM task_table")
    suspend fun resetTasks()
}
