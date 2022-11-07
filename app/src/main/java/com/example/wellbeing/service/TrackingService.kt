package com.example.wellbeing.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import androidx.lifecycle.LifecycleService
import com.example.wellbeing.utils.Constants.ACTION_PAUSE_SERVICE
import com.example.wellbeing.utils.Constants.ACTION_START_OR_RESUME_SERVICE
import com.example.wellbeing.utils.Constants.ACTION_STOP_SERVICE

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