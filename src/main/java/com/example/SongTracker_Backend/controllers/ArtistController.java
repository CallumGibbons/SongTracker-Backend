package com.example.SongTracker_Backend.controllers;

import com.example.SongTracker_Backend.Services.ArtistService;
import com.example.SongTracker_Backend.models.Artist;
import jakarta.persistence.Table;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Table(name = "artists")
public class ArtistController {

    private final ArtistService artistService;

    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    // Get all artists
    @GetMapping("/artists")
    public List<Artist> all() {
        return artistService.getAllArtists();
    }

    // Add a new artist
    @PostMapping("/artists")
    public Artist newArtist(@RequestBody Artist newArtist) {
        return artistService.createArtist(newArtist);
    }

    // Get a specific artist by artist_id
    @GetMapping("/artists/{artist_id}")
    public Artist one(@PathVariable Integer artist_id) {
        return artistService.getArtistById(artist_id);
    }

    // Update a specific artist by artist_id
    @PutMapping("/artists/{artist_id}")
    public Artist replaceArtist(@RequestBody Artist newArtist, @PathVariable Integer artist_id) {
        return artistService.updateArtist(artist_id, newArtist);
    }

    // Delete a specific artist by artist_id
    @DeleteMapping("/artists/{artist_id}")
    public void deleteArtist(@PathVariable Integer artist_id) {
        artistService.deleteArtist(artist_id);
    }
}
