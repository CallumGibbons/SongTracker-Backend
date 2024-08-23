package com.example.SongTracker_Backend.repos;

import com.example.SongTracker_Backend.models.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepo extends JpaRepository<Artist, Long> {
}
