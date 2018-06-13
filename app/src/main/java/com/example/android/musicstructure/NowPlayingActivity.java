package com.example.android.musicstructure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class NowPlayingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);

        // Get the intent that was used to start this activity
        Intent nowPlayingIntent = getIntent();

        // Grab the TextViews for song name and artist name
        TextView nowPlayingSongName = (TextView) findViewById(R.id.now_playing_song_name);
        TextView nowPlayingArtistName = (TextView) findViewById(R.id.now_playing_artist_name);

        // Set the layout song name and artist name to the values pulled from the intent
        nowPlayingSongName.setText(nowPlayingIntent.getStringExtra("SONG_NAME"));
        nowPlayingArtistName.setText(nowPlayingIntent.getStringExtra("ARTIST_NAME"));
    }
}