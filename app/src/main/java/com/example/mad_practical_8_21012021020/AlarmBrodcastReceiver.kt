package com.example.mad_practical_8_21012021020

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class AlarmBrodcastReceiver : BroadcastReceiver() {
companion object{
    val ALARMKEY="key"
    val ALARM_STOP="stop"
    val ALARM_START="start"
}

    override fun onReceive(context: Context, intent: Intent) {
     val data=intent.getStringExtra(ALARMKEY)
        val intentService=Intent(context,AlarmService::class.java)
        if(data== ALARM_START){
            context.startService(intentService)
        }
        else if(data== ALARM_STOP){
            context.stopService(intentService)
        }

    }
}