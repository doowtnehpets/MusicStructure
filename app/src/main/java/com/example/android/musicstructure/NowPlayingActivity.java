package com.example.android.musicstructure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static java.security.AccessController.getContext;

public class NowPlayingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);

        Intent nowPlayingIntent = getIntent();
        TextView nowPlayingSongName = (TextView)findViewById(R.id.now_playing_song_name);
        TextView nowPlayingArtistName = (TextView)findViewById(R.id.now_playing_artist_name);

        nowPlayingSongName.setText(nowPlayingIntent.getStringExtra("SONG_NAME"));
        nowPlayingArtistName.setText(nowPlayingIntent.getStringExtra("ARTIST_NAME"));
    }
}