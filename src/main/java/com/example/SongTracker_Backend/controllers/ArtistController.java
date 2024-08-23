package com.example.SongTracker_Backend.controllers;

import com.example.SongTracker_Backend.Exceptions.ArtistNotFoundException;
import com.example.SongTracker_Backend.models.Artist;
import com.example.SongTracker_Backend.repos.ArtistRepo;
import jakarta.persistence.Table;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Table(name = "artists")
@RestController
public class ArtistController {

    private final ArtistRepo repo;

    public ArtistController(ArtistRepo repo) {
        this.repo = repo;
    }

    // Get all listens
    @GetMapping("/artists")
    public List<Artist> all() {
        return repo.findAll();
    }

    // Add a new Artist
    @PostMapping("/artists")
    public Artist newArtist(@RequestBody Artist newArtist) {
        return repo.save(newArtist);
    }

    // Get a specific listen by history_id
    @GetMapping("/artists/{artist_id}")
    public Artist one(@PathVariable Integer artist_id) {
        return repo.findById(artist_id)
                .orElseThrow(() -> new ArtistNotFoundException(artist_id));
    }

    // Update a specific listen by history_id
    @PutMapping("/artists/{artist_id}")
    public Artist replaceArtist(@RequestBody Artist newArtist, @PathVariable Integer artist_id) {
        return repo.findById(artist_id)
                .map(artist -> {
                    artist.setName(newArtist.getName());
                    artist.set_favourite(newArtist.is_favourite());
                    artist.setAlbums(newArtist.getAlbums());
                    artist.setListens(newArtist.getListens());
                    return repo.save(artist);
                })
                .orElseGet(() -> {
                    newArtist.setArtist_id(artist_id); // Set the ID to the provided path variable
                    return repo.save(newArtist);
                });
    }

    // Delete a specific listen by history_id
    @DeleteMapping("/artists/{artist_id}")
    public void deleteListen(@PathVariable Integer artist_id) {
        repo.deleteById(artist_id);
    }
}
