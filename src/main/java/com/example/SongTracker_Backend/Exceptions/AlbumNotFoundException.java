package com.example.SongTracker_Backend.Exceptions;

public class AlbumNotFoundException extends RuntimeException {
    public AlbumNotFoundException(Integer album_id) {
        super("Could not find artist " + album_id);
    }
}
