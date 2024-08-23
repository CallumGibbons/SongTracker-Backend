package com.example.SongTracker_Backend.Exceptions;

public class SongNotFoundException extends RuntimeException{
    public SongNotFoundException(Integer song_id){
        super("Could not find song " + song_id);
    }
}
