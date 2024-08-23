package com.example.SongTracker_Backend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
@Entity
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int artist_id;

    private String name;
    private int listens;
    private boolean is_favourite;

    @OneToMany(mappedBy = "artist")
    private List<Album> albums;

    Artist(){}

    Artist(int artist_id, String name, int listens, boolean is_favourite, List<Album> albums){
        this.artist_id = artist_id;
        this.name = name;
        this.listens = listens;
        this.is_favourite = is_favourite;
        this.albums = albums;
    }

}
