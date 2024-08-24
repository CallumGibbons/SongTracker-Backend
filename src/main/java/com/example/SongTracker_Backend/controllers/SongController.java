package com.example.SongTracker_Backend.controllers;

import com.example.SongTracker_Backend.Services.SongService;
import com.example.SongTracker_Backend.models.Song;
import jakarta.persistence.Table;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Table(name = "songs")
@RestController
@RequestMapping("/songs")
public class SongController {

    private final SongService songService;

    public SongController(SongService songService) {
        this.songService = songService;
    }

    // Get all songs
    @GetMapping
    public List<Song> all() {
        return songService.getAllSongs();
    }

    // Add a new song
    @PostMapping
    public Song newSong(@RequestBody Song newSong) {
        return songService.saveSong(newSong);
    }

    // Get a specific song by ID
    @GetMapping("/{song_id}")
    public Song one(@PathVariable Integer song_id) {
        return songService.getSongById(song_id);
    }

    // Update a specific song by ID
    @PutMapping("/{song_id}")
    public Song replaceSong(@RequestBody Song newSong, @PathVariable Integer song_id) {
        return songService.updateSong(newSong, song_id);
    }

    // Delete a specific song by ID
    @DeleteMapping("/{song_id}")
    public void deleteSong(@PathVariable Integer song_id) {
        songService.deleteSongById(song_id);
    }
}
