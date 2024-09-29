package com.example.habitrackerwidget
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.widget.RemoteViews
import kotlinx.coroutines.runBlocking
import androidx.room.Room

class TaskWidgetProvider : AppWidgetProvider() {
    override fun onUpdate(context: Context, appWidgetManager: AppWidgetManager, appWidgetIds: IntArray) {
        for (appWidgetId in appWidgetIds) {
            // データベースから今日のタスクを取得する
            val taskList = runBlocking { getTasksFromDatabase(context) } // タスクを取得

            val remoteViews = RemoteViews(context.packageName, R.layout.widget_layout)
            remoteViews.setTextViewText(R.id.widget_title, "今日のタスク")

            // タスクのリストを文字列に変換して表示
            val taskNames = taskList.joinToString("\n") { it.taskName } // タスク名を取得
            remoteViews.setTextViewText(R.id.task_list, taskNames) // ウィジェットにタスク名を設定

            // ウィジェットを更新
            appWidgetManager.updateAppWidget(appWidgetId, remoteViews)
        }
    }

    private suspend fun getTasksFromDatabase(context: Context): List<Task> {
        val database = Room.databaseBuilder(
            context,
            TaskDatabase::class.java,
            "task_database"
        ).build()

        return database.taskDao().getTodaysTasks()
    }
}
