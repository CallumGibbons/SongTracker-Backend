package com.example.SongTracker_Backend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long album_id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "artist_id", nullable = false)
    private Artist artist;
    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Song> songs;
    private int listens;
    private boolean is_favourite;

    Album(){}

    Album(Long album_id, String name, Artist artist, List<Song> songs, int listens, boolean is_favourite){
        this.album_id = album_id;
        this.name = name;
        this.artist = artist;
        this.songs = songs;
        this.listens = listens;
        this.is_favourite = is_favourite;
    }


}
