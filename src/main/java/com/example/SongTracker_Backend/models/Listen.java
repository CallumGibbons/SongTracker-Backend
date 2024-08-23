package com.example.SongTracker_Backend.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Setter
@Getter
@Entity
@Table(name = "listening_history")
public class Listen {

    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) Integer history_id;
    private Timestamp listening_time;
    private String artist_name;
    private String album_name;
    private String song_name;

    Listen(){}

    Listen(Integer history_id,String song_name, Timestamp listening_time, String artist_name, String album_name){
        this.history_id = history_id;
        this.album_name = album_name;
        this.artist_name = artist_name;
        this.song_name = song_name;
        this.listening_time = listening_time;
    }

}
