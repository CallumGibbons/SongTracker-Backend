package com.example.SongTracker_Backend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
@Entity
@Table(name = "artists")
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer artist_id;

    private String name;
    private Integer listens;
    private boolean is_favourite;

    @OneToMany(mappedBy = "artist", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Album> albums;

    Artist(){}

    Artist(Integer artist_id, String name, int listens, boolean is_favourite, List<Album> albums){
        this.artist_id = artist_id;
        this.name = name;
        this.listens = listens;
        this.is_favourite = is_favourite;
        this.albums = albums;
    }

}
