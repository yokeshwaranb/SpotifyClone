package com.training.spotifyclone.di;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.training.spotifyclone.R;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

/**
  *  Ref: https://stackoverflow.com/questions/65988186/error-cannot-find-symbol-dagger-hilt-installinvalue-applicationcomponent-c
  *  ApplicationComponent is Deprecated in Dagger Version 2.30
  *  Alternatively SingletonComponent should be used instead of ApplicationComponent
 */
@Module
@InstallIn(SingletonComponent.class)
public class AppModule {

    @Singleton
    @Provides
    public RequestManager provideGlideInstance(@ApplicationContext Context context) {
        return Glide.with(context).setDefaultRequestOptions(
                new RequestOptions()
                        .placeholder(R.drawable.ic_image)
                        .error(R.drawable.ic_image)
                        .diskCacheStrategy(DiskCacheStrategy.DATA)
        );
    }
}
