package com.example.habitrackerwidget

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Task::class], version = 1, exportSchema = false) // exportSchemaをfalseに設定
abstract class TaskDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
}