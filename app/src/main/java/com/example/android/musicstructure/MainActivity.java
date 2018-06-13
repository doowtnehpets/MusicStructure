package com.example.android.musicstructure;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Declare the list of songs
        ArrayList<Song> songsList = new ArrayList<>();

        // Set up InputStream from the songs.csv file (list of songs)
        InputStream inputStream = getResources().openRawResource(R.raw.songs);

        // Create a new BufferedReader to read each line of the songs.csv file
        BufferedReader reader =  new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));

        // Loop through the lines of the CSV and add a new song for each line to the list of songs
        String line = "";
        try {
            // Skip over the header of the CSV file
            reader.readLine();

            // While there's still lines, keep looping until finished
            while( (line = reader.readLine()) != null ){
                // Split by commas ','
                String[] tokens = line.split(",");

                // Store data pulled from the current line in the songsList ArrayList
                Song songToAdd = new Song( Integer.valueOf(tokens[0]), tokens[1], tokens[2]);
                songsList.add(songToAdd);
                // Log what was loaded
                Log.d("MainActivity", "Added: " + songToAdd);
            }
        } catch (IOException e) {
            // Log any error message from IOException
            Log.wtf("MainActivity","Error reading data file on line " + line, e);
            e.printStackTrace();
        }

        // Create a new SongAdapter and apply it to the songs_list ListView to show a list of songs
        SongAdapter songAdapter = new SongAdapter(this, songsList);
        ListView listView = (ListView)findViewById(R.id.songs_list);
        listView.setAdapter(songAdapter);

    }
}
