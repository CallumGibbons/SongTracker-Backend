package com.example.SongTracker_Backend.Exceptions;

public class ArtistNotFoundException extends RuntimeException {
    public ArtistNotFoundException(Integer artist_id){
        super("Could not find artist " + artist_id);
    }
}
