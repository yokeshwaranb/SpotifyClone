package com.training.spotifyclone.di;

import android.content.Context;
import android.util.Log;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.upstream.DefaultDataSource;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ServiceComponent;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.android.scopes.ServiceScoped;

@Module
@InstallIn(ServiceComponent.class)
public class ServiceModule {

    private static final String TAG = "MyServiceModule";

    /**
     * C.CONTENT_TYPE_MUSIC is changed to C.AUDIO_CONTENT_TYPE_MUSIC
     */
    @ServiceScoped
    @Provides
    public AudioAttributes provideAudioAttributes() {
        Log.d(TAG, "@provideAudioAttributes()");
        return new AudioAttributes.Builder()
                .setContentType(C.AUDIO_CONTENT_TYPE_MUSIC)
                .setUsage(C.USAGE_MEDIA)
                .build();
    }

    @ServiceScoped
    @Provides
    public ExoPlayer provideExoPlayer(
            @ApplicationContext Context context,
            AudioAttributes audioAttributes
    ) {
        Log.d(TAG, "@provideExoPlayer()");
        return new ExoPlayer.Builder(context)
                .setAudioAttributes(audioAttributes, true)
                .setHandleAudioBecomingNoisy(true)
                .build();
    }

    /**
     * DefaultDataSourceFactory is Deprecated
     * using DefaultDataSource.Factory instead
     * */
    @ServiceScoped
    @Provides
    public DefaultDataSource.Factory provideDataSourceFactory(
            @ApplicationContext Context context
    ) {
        Log.d(TAG, "@provideDataSourceFactory()");
        return new DefaultDataSource.Factory(context);
    }
}
