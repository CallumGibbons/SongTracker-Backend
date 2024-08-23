package com.example.SongTracker_Backend.repos;

import com.example.SongTracker_Backend.models.Song;
import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Table(name = "songs")
@Repository
public interface SongRepo extends JpaRepository<Song, Integer> {
}
