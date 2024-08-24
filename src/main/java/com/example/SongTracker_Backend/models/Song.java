package com.example.SongTracker_Backend.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "songs")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer song_id;
    private boolean is_favourite;
    private String name;
    private Integer listens;
    @ManyToOne
    @JoinColumn(name = "album_id", nullable = false)
    private Album album;
    @ManyToOne
    @JoinColumn(name = "artist_id", nullable = false)
    @JsonIgnore
    private Artist artist;


    Song(){}

    Song(Integer song_id, String name, Integer listens, boolean is_favourite, Album album, Artist artist){
        this.song_id = song_id;
        this.name = name;
        this.listens = listens;
        this.is_favourite = is_favourite;
        this.album = album;
        this.artist = artist;
    }

    public boolean isIs_favourite() {
        return is_favourite;
    }
}
