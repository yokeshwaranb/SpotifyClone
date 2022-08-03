package com.training.spotifyclone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.bumptech.glide.RequestManager;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    @Inject
    RequestManager requestManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}