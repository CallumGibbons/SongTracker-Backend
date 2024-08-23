package com.example.SongTracker_Backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.JoinColumn;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int album_id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "artist_id")
    private Artist artist;
    @OneToMany(mappedBy = "album")
    private List<Song> songs;
    private int listens;

    Album(){}

    Album(int album_id, String name, Artist artist, List<Song> songs, int listens){
        this.album_id = album_id;
        this.name = name;
        this.artist = artist;
        this.songs = songs;
        this.listens = listens;
    }

    private boolean is_favourite;


}
