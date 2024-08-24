package com.example.SongTracker_Backend.controllers;

import com.example.SongTracker_Backend.Services.AlbumService;
import com.example.SongTracker_Backend.models.Album;
import jakarta.persistence.Table;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Table(name = "albums")
public class AlbumController {

    private final AlbumService albumService;

    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    // Get all albums
    @GetMapping("/albums")
    public List<Album> all() {
        return albumService.getAllAlbums();
    }

    // Add a new album
    @PostMapping("/albums")
    public Album newAlbum(@RequestBody Album newAlbum) {
        return albumService.createAlbum(newAlbum);
    }

    // Get a specific album by album_id
    @GetMapping("/albums/{album_id}")
    public Album one(@PathVariable Integer album_id) {
        return albumService.getAlbumById(album_id);
    }

    // Update a specific album by album_id
    @PutMapping("/albums/{album_id}")
    public Album replaceAlbum(@RequestBody Album newAlbum, @PathVariable Integer album_id) {
        return albumService.updateAlbum(album_id, newAlbum);
    }

    // Delete a specific album by album_id
    @DeleteMapping("/albums/{album_id}")
    public void deleteAlbum(@PathVariable Integer album_id) {
        albumService.deleteAlbum(album_id);
    }
}
