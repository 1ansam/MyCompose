package com.yxf.mycompose

import android.annotation.SuppressLint
import android.app.ActivityManager
import android.app.Application
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.wifi.WifiManager
import android.util.Log
import android.widget.Toast

/**
 *   author:yxf
 *   time:2022/6/16
 */
class MyApp : Application() {
    companion object{
//        @SuppressLint("StaticFieldLeak")
//        lateinit var context: Context
//        lateinit var manager: ActivityManager
    }
    override fun onCreate() {
        super.onCreate()
        Log.e("TAG1", "onCreate: ", )
//        context = applicationContext
//        manager = context.getSystemService(ACTIVITY_SERVICE) as ActivityManager

    }



}