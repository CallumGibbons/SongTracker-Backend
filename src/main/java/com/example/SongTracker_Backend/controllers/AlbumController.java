package com.example.SongTracker_Backend.controllers;

import com.example.SongTracker_Backend.Exceptions.AlbumNotFoundException;
import com.example.SongTracker_Backend.models.Album;
import com.example.SongTracker_Backend.repos.AlbumRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AlbumController {
    private final AlbumRepo repo;

    public AlbumController(AlbumRepo repo) {
        this.repo = repo;
    }

    // Get all albums
    @GetMapping("/albums")
    public List<Album> all() {
        return repo.findAll();
    }

    // Add a new Album
    @PostMapping("/albums")
    public Album newAlbum(@RequestBody Album newAlbum) {
        return repo.save(newAlbum);
    }

    // Get a specific album by album_id
    @GetMapping("/albums/{album_id}")
    public Album one(@PathVariable Long album_id) {
        return repo.findById(album_id)
                .orElseThrow(() -> new AlbumNotFoundException(album_id));
    }

    // Update a specific album by album_id
    @PutMapping("/albums/{album_id}")
    public Album replaceAlbum(@RequestBody Album newAlbum, @PathVariable Long album_id) {
        return repo.findById(album_id)
                .map(album -> {
                    album.setName(newAlbum.getName());
                    album.set_favourite(newAlbum.is_favourite());
                    album.setArtist(newAlbum.getArtist());
                    album.setListens(newAlbum.getListens());
                    album.setSongs(newAlbum.getSongs());
                    return repo.save(album);
                })
                .orElseGet(() -> {
                    newAlbum.setAlbum_id(album_id); // Set the ID to the provided path variable
                    return repo.save(newAlbum);
                });
    }

    // Delete a specific album by album_id
    @DeleteMapping("/albums/{album_id}")
    public void deleteAlbum(@PathVariable Long album_id) {
        repo.deleteById(album_id);
    }
}
