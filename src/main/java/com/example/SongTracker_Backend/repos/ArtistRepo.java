package com.example.SongTracker_Backend.repos;

import com.example.SongTracker_Backend.models.Artist;
import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Table(name = "artists")
@Repository
public interface ArtistRepo extends JpaRepository<Artist, Integer> {
}
