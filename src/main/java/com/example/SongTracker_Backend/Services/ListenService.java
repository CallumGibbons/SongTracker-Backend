package com.example.SongTracker_Backend.Services;

import com.example.SongTracker_Backend.Exceptions.ListenNotFoundException;
import com.example.SongTracker_Backend.models.Listen;
import com.example.SongTracker_Backend.repos.ListenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ListenService {

    @Autowired
    private ListenRepo listenRepo;

    // Get all listens
    public List<Listen> getAllListens() {
        return listenRepo.findAll();
    }

    // Get a specific listen by history_id
    public Listen getListenById(Integer history_id) {
        return listenRepo.findById(history_id)
                .orElseThrow(() -> new ListenNotFoundException(history_id));
    }

    // Add a new listen
    public Listen createListen(Listen newListen) {
        return listenRepo.save(newListen);
    }

    // Update a specific listen by history_id
    @Transactional
    public Listen updateListen(Integer history_id, Listen newListen) {
        return listenRepo.findById(history_id)
                .map(listen -> {
                    listen.setAlbum_name(newListen.getAlbum_name());
                    listen.setListening_time(newListen.getListening_time());
                    listen.setSong_name(newListen.getSong_name());
                    listen.setArtist_name(newListen.getArtist_name());
                    return listenRepo.save(listen);
                })
                .orElseGet(() -> {
                    newListen.setHistory_id(history_id); // Set the ID to the provided path variable
                    return listenRepo.save(newListen);
                });
    }

    // Delete a specific listen by history_id
    @Transactional
    public void deleteListen(Integer history_id) {
        listenRepo.deleteById(history_id);
    }
}
