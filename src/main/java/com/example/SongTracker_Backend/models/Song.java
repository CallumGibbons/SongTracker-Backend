package com.example.SongTracker_Backend.models;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int song_id;
    private String name;
    private int listens;
    private boolean is_favourite;
    @ManyToOne
    @JoinColumn(name = "album_id")
    private Album album;
    @ManyToOne
    @JoinColumn(name = "artist_id")
    private Artist artist;

    Song(){}

    Song(int song_id, String name, int listens, boolean is_favourite, Album album, Artist artist){
        this.song_id = song_id;
        this.name = name;
        this.listens = listens;
        this.is_favourite = is_favourite;
        this.album = album;
        this.artist = artist;
    }

}
