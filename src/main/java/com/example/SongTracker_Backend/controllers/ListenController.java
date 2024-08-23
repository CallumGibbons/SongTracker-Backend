package com.example.SongTracker_Backend.controllers;

import com.example.SongTracker_Backend.Exceptions.ListenNotFoundException;
import com.example.SongTracker_Backend.models.Listen;
import com.example.SongTracker_Backend.repos.ListenRepo;
import jakarta.persistence.Table;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Table(name = "listening_history")
@RestController
public class ListenController {

    private final ListenRepo repo;

    public ListenController(ListenRepo repo) {
        this.repo = repo;
    }

    // Get all listens
    @GetMapping("/listens")
    public List<Listen> all() {
        return repo.findAll();
    }

    // Add a new listen
    @PostMapping("/listens")
    public Listen newListen(@RequestBody Listen newListen) {
        return repo.save(newListen);
    }

    // Get a specific listen by history_id
    @GetMapping("/listens/{history_id}")
    public Listen one(@PathVariable Integer history_id) {
        return repo.findById(history_id)
                .orElseThrow(() -> new ListenNotFoundException(history_id));
    }

    // Update a specific listen by history_id
    @PutMapping("/listens/{history_id}")
    public Listen replaceListen(@RequestBody Listen newListen, @PathVariable Integer history_id) {
        return repo.findById(history_id)
                .map(listen -> {
                    listen.setAlbum_name(newListen.getAlbum_name());
                    listen.setListening_time(newListen.getListening_time());
                    listen.setSong_name(newListen.getSong_name());
                    listen.setArtist_name(newListen.getArtist_name());
                    return repo.save(listen);
                })
                .orElseGet(() -> {
                    newListen.setHistory_id(history_id); // Set the ID to the provided path variable
                    return repo.save(newListen);
                });
    }

    // Delete a specific listen by history_id
    @DeleteMapping("/listens/{history_id}")
    public void deleteListen(@PathVariable Integer history_id) {
        repo.deleteById(history_id);
    }
}
