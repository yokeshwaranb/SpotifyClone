package com.training.spotifyclone.exoplayer;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.MediaSessionCompat;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.media.MediaBrowserServiceCompat;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.upstream.DefaultDataSource;
import com.google.android.exoplayer2.ext.mediasession.MediaSessionConnector;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MusicService extends MediaBrowserServiceCompat {

    private final String SERVICE_TAG = "MusicService";

    @Inject
    DefaultDataSource.Factory dataSourceFactory;

    @Inject
    ExoPlayer exoPlayer;

    MediaSessionCompat mediaSessionCompat;
    MediaSessionConnector mediaSessionConnector;

    @Override
    public void onCreate() {
        super.onCreate();

        Intent intent= getPackageManager().getLaunchIntentForPackage(getPackageName());
        PendingIntent pendingIntent = null;
        if(intent == null) {
            pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
        }

        mediaSessionCompat = new MediaSessionCompat(this, SERVICE_TAG);
        mediaSessionCompat.setSessionActivity(pendingIntent);
        mediaSessionCompat.setActive(true);

        setSessionToken(mediaSessionCompat.getSessionToken());

        mediaSessionConnector = new MediaSessionConnector(mediaSessionCompat);
        mediaSessionConnector.setPlayer(exoPlayer);
    }

    @Nullable
    @Override
    public BrowserRoot onGetRoot(@NonNull String clientPackageName, int clientUid, @Nullable Bundle rootHints) {
        return null;
    }

    @Override
    public void onLoadChildren(@NonNull String parentId, @NonNull Result<List<MediaBrowserCompat.MediaItem>> result) {

    }
}
