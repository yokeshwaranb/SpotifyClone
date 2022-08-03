package com.training.spotifyclone;

import android.app.Application;
import android.util.Log;

import dagger.hilt.android.HiltAndroidApp;

@HiltAndroidApp
public class SpotifyApplication extends Application {

    private static final String TAG = "MySpotifyApplication";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "@onCreate()");
    }
}
