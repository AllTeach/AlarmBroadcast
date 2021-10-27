package com.example.alarmbroadcast;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void setAlarm(View view)
    {
        // create intent
        Intent intent = new Intent(this,AlarmReceiver.class);
        // pending intent -> broadcast
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(),1,intent,0);
        // set Alarm manager with alarm
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        alarmManager.setAndAllowWhileIdle(AlarmManager.ELAPSED_REALTIME_WAKEUP, SystemClock.elapsedRealtime() + 20*1000,pendingIntent);

    }
}