package com.example.SongTracker_Backend.Exceptions;

public class ListenNotFoundException extends RuntimeException{
    public ListenNotFoundException(long history_id){
        super("Could not find listen " + history_id);
    }
}
