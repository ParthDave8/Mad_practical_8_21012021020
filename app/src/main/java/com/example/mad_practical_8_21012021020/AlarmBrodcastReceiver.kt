package com.example.mad_practical_8_21012021020

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class AlarmBrodcastReceiver : BroadcastReceiver() {
    companion object{
        val ALARMKEY="key"
        val ALARM_STOP="value"
        val ALARM_START="start"
    }
    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        val data=intent.getStringExtra(ALARMKEY)
        val intent_service=Intent(context,AlarmService::class.java)
        if(data== ALARM_START){
            context.startService(intent_service)
        }
        else if(data== ALARM_STOP){
            context.stopService(intent_service)
        }
    }
}