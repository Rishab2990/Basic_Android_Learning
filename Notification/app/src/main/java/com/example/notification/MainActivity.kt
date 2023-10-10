package com.example.notification

import android.Manifest
import android.annotation.SuppressLint
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.CalendarContract.Colors
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.graphics.green

class MainActivity : AppCompatActivity() {

  val CHANNEL_ID = "channelId"
  val CHANNEL_NAME = "channelName"
  val NotificationId = 0


    @SuppressLint("MissingPermission", "SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = Intent(this,MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivities(this,0, arrayOf(intent),PendingIntent.FLAG_IMMUTABLE)

        createNotificationChannel()
        val NotificationCall = NotificationCompat.Builder(this , CHANNEL_NAME)
            .setContentTitle("Today I learned Notification Channel and notification")
            .setContentText("Congratulation you are completely understand Notification concept")
            .setSmallIcon(R.drawable.baseline_touch_app_24)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(pendingIntent)
            .build()

        val notification = NotificationManagerCompat.from(this)
         val button  = findViewById<Button>(R.id.btn)


            button.setOnClickListener {
                notification.notify(0,NotificationCall)

        }

    }



    fun createNotificationChannel(){
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            val channel = NotificationChannel(CHANNEL_ID ,CHANNEL_NAME , NotificationManager.IMPORTANCE_DEFAULT).apply {
                description = "Someone Send Message you"
                lightColor = Color.GREEN
                enableLights(true)
            }

            val Manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            Manager.createNotificationChannel(channel)
        }
    }
}


