package com.example.habitrackerwidget

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class NotificationReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val taskName = intent.getStringExtra("TASK_NAME")
        Toast.makeText(context, "未チェックタスク: $taskName", Toast.LENGTH_SHORT).show()
        // 実際の通知機能をここに追加
    }
}
