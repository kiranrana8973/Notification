package com.kiran.notification

import android.app.PendingIntent
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class MainActivity : AppCompatActivity() {

    private lateinit var btnNotification1 : Button
    private lateinit var btnNotification2 : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnNotification1 = findViewById(R.id.btnNotification1)
        btnNotification2 = findViewById(R.id.btnNotification2)
        btnNotification1.setOnClickListener {
            showHighPriorityNotification()
        }
        btnNotification2.setOnClickListener {
            showLowPriorityNotification()
        }
    }
    private fun showHighPriorityNotification() {

        val notificationManager = NotificationManagerCompat.from(this)

        val notificationChannels = NotificationChannels(this)
        notificationChannels.createNotificationChannels()

        val notification = NotificationCompat.Builder(this, notificationChannels.CHANNEL_1)
                .setSmallIcon(R.drawable.notification)
                .setContentTitle("High priority notification")
                .setContentText("This is my notification body")
                .setColor(Color.BLUE)
                .build()

        notificationManager.notify(1, notification)

    }
    private fun showLowPriorityNotification() {
        val notificationManager = NotificationManagerCompat.from(this)

        val notificationChannels = NotificationChannels(this)
        notificationChannels.createNotificationChannels()

        val notification = NotificationCompat.Builder(this, notificationChannels.CHANNEL_2)
                .setSmallIcon(R.drawable.notification)
                .setContentTitle("Low priority notification")
                .setContentText("This is my notification body")
                .setColor(Color.BLUE)
                .build()

        notificationManager.notify(2, notification)
    }


}