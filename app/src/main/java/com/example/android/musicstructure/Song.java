package com.example.android.musicstructure;

/**
 * Class to hold songs from the list of songs imported
 */
public class Song {

    // Not displayed anywhere, just used as a reference for future implementation
    private int songIndex;

    // The song name of course
    private String songName;

    // The artist of the song
    private String artistName;

    public Song(int songIndex, String songName, String artistName) {
        this.songIndex = songIndex;
        this.songName = songName;
        this.artistName = artistName;
    }

    public int getSongIndex() {
        return songIndex;
    }

    public void setSongIndex(int songIndex) {
        this.songIndex = songIndex;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    @Override
    public String toString() {
        return "Song{" +
                "songIndex=" + songIndex +
                ", songName='" + songName + '\'' +
                ", artistName='" + artistName + '\'' +
                '}';
    }
}
