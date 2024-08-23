package com.example.SongTracker_Backend.repos;

import com.example.SongTracker_Backend.models.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepo extends JpaRepository<Album, Long> {
}
