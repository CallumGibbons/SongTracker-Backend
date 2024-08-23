package com.example.SongTracker_Backend.controllers;

import com.example.SongTracker_Backend.Exceptions.SongNotFoundException;
import com.example.SongTracker_Backend.models.Song;
import com.example.SongTracker_Backend.repos.SongRepo;
import jakarta.persistence.Table;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Table(name = "songs")
@RestController
public class SongController {

    private final SongRepo repo;

    public SongController(SongRepo repo) {
        this.repo = repo;
    }

    // Get all songs
    @GetMapping("/songs")
    public List<Song> all() {
        return repo.findAll();
    }

    // Add a new song
    @PostMapping("/songs")
    public Song newSong(@RequestBody Song newSong) {
        return repo.save(newSong);
    }

    // Get a specific song by ID
    @GetMapping("/songs/{song_id}")
    public Song one(@PathVariable Integer song_id) {
        return repo.findById(song_id)
                .orElseThrow(() -> new SongNotFoundException(song_id));
    }

    // Update a specific song by ID
    @PutMapping("/songs/{song_id}")
    public Song replaceSong(@RequestBody Song newSong, @PathVariable Integer song_id) {
        return repo.findById(song_id)
                .map(song -> {
                    song.setName(newSong.getName());
                    song.setAlbum(newSong.getAlbum());
                    song.setArtist(newSong.getArtist());
                    song.set_favourite(newSong.isIs_favourite());
                    song.setListens(newSong.getListens());
                    return repo.save(song);
                })
                .orElseGet(() -> {
                    newSong.setSong_id(song_id); // Set the ID to the provided path variable
                    return repo.save(newSong);
                });
    }

    // Delete a specific song by ID
    @DeleteMapping("/songs/{song_id}")
    public void deleteSong(@PathVariable Integer song_id) {
        repo.deleteById(song_id);
    }
}
