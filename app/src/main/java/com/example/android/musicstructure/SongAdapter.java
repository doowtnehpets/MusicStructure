package com.example.android.musicstructure;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class SongAdapter extends ArrayAdapter<Song> {

    public SongAdapter(Activity context, ArrayList<Song> songs) {
        /*
        Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        the second argument is used when the ArrayAdapter is populating a single TextView.
        Because this is a custom adapter for two TextViews, the adapter is not
        going to use this second argument, so it can be any value. Here, we used 0.
        */
        super(context, 0, songs);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.song_item, parent, false);
        }

        // Get the {@link Song} object located at this position in the list
        Song currentSong = getItem(position);

        // Find the TextView in the song_item.xml layout with the ID song_name
        TextView songIndexTextView = (TextView) listItemView.findViewById(R.id.song_name);
        // Get the song name from the current Song object and
        // set this text on the Song Name TextView
        songIndexTextView.setText(currentSong.getSongName());

        // Find the TextView in the song_item.xml layout with the ID artist_name
        TextView artistNameTextView = (TextView) listItemView.findViewById(R.id.artist_name);
        // Get the version number from the current Song object and
        // set this text on the Artist Name TextView
        artistNameTextView.setText(currentSong.getArtistName());

        // Get the LinearLayout to set the OnClickListener for the song
        LinearLayout songLayout = (LinearLayout) listItemView.findViewById(R.id.song_layout);
        // Set the OnClick listener for the  LinearLayout
        songLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nowPlayingIntent = new Intent(getContext(), NowPlayingActivity.class);
                getContext().startActivity(nowPlayingIntent);
            }
        });

        // Return the whole list item layout
        // so that it can be shown in the ListView
        return listItemView;
    }
}
