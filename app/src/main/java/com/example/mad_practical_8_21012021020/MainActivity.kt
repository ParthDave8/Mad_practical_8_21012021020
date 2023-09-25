package com.example.mad_practical_8_21012021020

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.button.MaterialButton
import com.google.android.material.card.MaterialCardView
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var create:MaterialButton=findViewById(R.id.create)
        create.setOnClickListener() {
            var p: MaterialCardView = findViewById(R.id.materialcard2)
            p.visibility = View.VISIBLE
        }
    }
    fun setAlarm(Militime:Long,action:String){
        val intentAlarm=Intent(applicationContext,AlarmBrodcastReceiver::class.java)
        intentAlarm.putExtra(AlarmBrodcastReceiver.ALARMKEY,action)
        val pendingIntent=PendingIntent.getBroadcast(applicationContext,2345,intentAlarm,PendingIntent.FLAG_UPDATE_CURRENT)
        val manager=getSystemService(ALARM_SERVICE) as AlarmManager
        if(action==AlarmBrodcastReceiver.ALARM_START){
            manager.setExact(AlarmManager.RTC_WAKEUP,Militime,pendingIntent)
        }
    }
}