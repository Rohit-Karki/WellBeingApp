package com.rohit.wellbeing.helpers

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Build
import androidx.core.app.NotificationCompat
import com.rohit.wellbeing.R
import com.rohit.wellbeing.MainActivity

class NotificationHelper(private val ctx: Context) {

        private var notificationManager: NotificationManager? = null
        private val  CHANNEL_ONE_ID = "io.github.z3r0c00l_2k.aquadroid.CHANNELONE"
        private val CHANNEL_ONE_NAME = "Channel One"

        private fun createChannel() {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val notificationChannel = NotificationChannel(
                    CHANNEL_ONE_ID,
                    CHANNEL_ONE_NAME, NotificationManager.IMPORTANCE_HIGH
                )
                notificationChannel.enableLights(true)
                notificationChannel.lightColor = Color.BLUE
                notificationChannel.setShowBadge(true)
                notificationChannel.lockscreenVisibility = Notification.VISIBILITY_PUBLIC

                getManager()!!.createNotificationChannel(notificationChannel)
            }
        }

        fun getNotification(
            title: String,
            body: String,
            notificationsTone: String?
        ): NotificationCompat.Builder? {
            createChannel()
            val notification = NotificationCompat.Builder(ctx.applicationContext, CHANNEL_ONE_ID)
                .setContentTitle(title)
                .setContentText(body)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setAutoCancel(true)

            notification.setShowWhen(true)

            notification.setSound(Uri.parse(notificationsTone))

            val notificationIntent = Intent(ctx, MainActivity::class.java)

            notificationIntent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            val contentIntent =
                PendingIntent.getActivity(ctx, 99, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT)

            notification.setContentIntent(contentIntent)

            return notification
        }

        fun notify(id: Long, notification: NotificationCompat.Builder?) {
                getManager()!!.notify(id.toInt(), notification!!.build())
        }

        private fun getManager(): NotificationManager? {
            if (notificationManager == null) {
                notificationManager = ctx.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            }
            return notificationManager
        }
}
