package com.example.SongTracker_Backend.controllers;

import com.example.SongTracker_Backend.Services.ListenService;
import com.example.SongTracker_Backend.models.Listen;
import jakarta.persistence.Table;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Table(name = "listening_history")
public class ListenController {

    private final ListenService listenService;

    public ListenController(ListenService listenService) {
        this.listenService = listenService;
    }

    // Get all listens
    @GetMapping("/listens")
    public List<Listen> all() {
        return listenService.getAllListens();
    }

    // Add a new listen
    @PostMapping("/listens")
    public Listen newListen(@RequestBody Listen newListen) {
        return listenService.createListen(newListen);
    }

    // Get a specific listen by history_id
    @GetMapping("/listens/{history_id}")
    public Listen one(@PathVariable Integer history_id) {
        return listenService.getListenById(history_id);
    }

    // Update a specific listen by history_id
    @PutMapping("/listens/{history_id}")
    public Listen replaceListen(@RequestBody Listen newListen, @PathVariable Integer history_id) {
        return listenService.updateListen(history_id, newListen);
    }

    // Delete a specific listen by history_id
    @DeleteMapping("/listens/{history_id}")
    public void deleteListen(@PathVariable Integer history_id) {
        listenService.deleteListen(history_id);
    }
}
