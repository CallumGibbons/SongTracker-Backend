package com.example.SongTracker_Backend.repos;

import com.example.SongTracker_Backend.models.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepo extends JpaRepository<Song, Long> {
}
