package com.example.SongTracker_Backend.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Setter
@Getter
@Entity
public class Listen {

    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) int history_id;
    private Timestamp listening_time;
    private String artist_name;
    private String album_name;
    private String song_name;

    Listen(){}

    Listen(String song_name, Timestamp listening_time, String artist_name, String album_name){
        this.album_name = album_name;
        this.artist_name = artist_name;
        this.song_name = song_name;
        this.listening_time = listening_time;
    }

}
