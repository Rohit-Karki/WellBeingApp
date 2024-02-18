//package com.example.wellbeing.service
//
//import android.app.NotificationChannel
//import android.app.NotificationManager
//import android.app.NotificationManager.IMPORTANCE_LOW
//import android.app.PendingIntent
//import android.app.PendingIntent.FLAG_UPDATE_CURRENT
//import android.app.Service
//import android.content.Context
//import android.content.Intent
//import android.os.Build
//import android.os.IBinder
//import android.util.Log
//import androidx.annotation.RequiresApi
//import androidx.core.app.NotificationCompat
//import androidx.lifecycle.LifecycleService
//import androidx.lifecycle.ViewTreeLifecycleOwner.set
//import com.rohit.wellbeing.MainActivity
//import com.rohit.wellbeing.R
//import com.rohit.wellbeing.utils.Constants
//import com.rohit.wellbeing.utils.Constants.ACTION_PAUSE_SERVICE
//import com.rohit.wellbeing.utils.Constants.ACTION_SHOW_TRACKING_FRAGMENT
//import com.rohit.wellbeing.utils.Constants.ACTION_START_OR_RESUME_SERVICE
//import com.rohit.wellbeing.utils.Constants.ACTION_STOP_SERVICE
//import com.rohit.wellbeing.utils.Constants.NOTIFICATION_CHANNEL_ID
//import com.rohit.wellbeing.utils.Constants.NOTIFICATION_ID
//
//class StepService: LifecycleService(){
//    var isFirstRun = true
//    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
//        intent?.let {
//            when(it.action) {
//                ACTION_START_OR_RESUME_SERVICE -> {
//                    if(isFirstRun) {
//                        startForegroundService()
//                        isFirstRun = false
//                    } else {
//                        Log.d("on start","Resuming service...")
//                    }
//                }
//                ACTION_PAUSE_SERVICE -> {
//                    Log.e("on pause","Paused service")
//                }
//                ACTION_STOP_SERVICE -> {
//                    Log.e("on stop","Stopped service")
//                }
//                else -> {}
//            }
//        }
//
//        return super.onStartCommand(intent, flags, startId)
//    }
//    private fun startForegroundService(){
//        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE)
//                as NotificationManager
//
//        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            createNotificationChannel(notificationManager)
//        }
//
//        val notificationBuilder = NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID)
//            .setAutoCancel(false)
//            .setOngoing(true)
//            .setSmallIcon(R.drawable.ic_launcher_foreground)
//            .setContentTitle("WellBeing App")
//            .setContentText("100 steps")
//            .setContentIntent(getMainActivityPendingIntent())
//
//        startForeground(NOTIFICATION_ID, notificationBuilder.build())
//    }
//
//    private fun getMainActivityPendingIntent() = PendingIntent.getActivity(
//        this,
//        0,
//        Intent(this, MainActivity::class.java).also {
//            it.action = ACTION_SHOW_TRACKING_FRAGMENT
//        },
//        FLAG_UPDATE_CURRENT
//    )
//
//    private fun updateNotificationTrackingState(isTracking: Boolean) {
//        val notificationActionText = if(isTracking) "Pause" else "Resume"
//        val pendingIntent = if(isTracking) {
//            val pauseIntent = Intent(this, StepService::class.java).apply {
//                action = ACTION_PAUSE_SERVICE
//            }
//            PendingIntent.getService(this, 1, pauseIntent, FLAG_UPDATE_CURRENT)
//        } else {
//            val resumeIntent = Intent(this, StepService::class.java).apply {
//                action = ACTION_START_OR_RESUME_SERVICE
//            }
//            PendingIntent.getService(this, 2, resumeIntent, FLAG_UPDATE_CURRENT)
//        }
//
//        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
//
//        curNotificationBuilder.javaClass.getDeclaredField("mActions").apply {
//            isAccessible = true
//            set(curNotificationBuilder, ArrayList<NotificationCompat.Action>())
//        }
//        curNotificationBuilder = baseNotificationBuilder
//            .addAction(R.drawable.ic_pause_black_24dp, notificationActionText, pendingIntent)
//        notificationManager.notify(NOTIFICATION_ID, curNotificationBuilder.build())
//    }
//
//
//    @RequiresApi(Build.VERSION_CODES.O)
//    private fun createNotificationChannel(notificationManger:NotificationManager){
//        val channel = NotificationChannel(
//            Constants.NOTIFICATION_CHANNEL_ID,
//            Constants.NOTIFICATION_CHANNEL_NAME,
//            IMPORTANCE_LOW
//        )
//        notificationManger.createNotificationChannel(channel)
//    }
//}
//
package com.rohit.wellbeing.service

import android.content.Intent
import android.util.Log
import androidx.lifecycle.LifecycleService
import com.rohit.wellbeing.utils.Constants.ACTION_PAUSE_SERVICE
import com.rohit.wellbeing.utils.Constants.ACTION_START_OR_RESUME_SERVICE
import com.rohit.wellbeing.utils.Constants.ACTION_STOP_SERVICE

class TrackingService: LifecycleService(){
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        intent?.let {
            when(it.action) {
                ACTION_START_OR_RESUME_SERVICE -> {
                    Log.e("onStart","Started or resumed service")
                }
                ACTION_PAUSE_SERVICE -> {
                    Log.e("on pause","Paused service")
                }
                ACTION_STOP_SERVICE -> {
                    Log.e("on stop","Stopped service")
                }
                else -> {}
            }
        }

        return super.onStartCommand(intent, flags, startId)
    }
}
