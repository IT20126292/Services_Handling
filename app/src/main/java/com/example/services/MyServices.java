package com.example.services;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;

import androidx.annotation.Nullable;

public class MyServices extends Service{
    private MediaPlayer player;

    @Override
    public void onCreate() {
        super.onCreate();
        MediaPlayer player = MediaPlayer.create(this, R.raw.teriyaki_boyz);
        player.setLooping(true);
        player.start();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        player.start();
        //return START_STICKY;
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        player.start();
        player.release();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
