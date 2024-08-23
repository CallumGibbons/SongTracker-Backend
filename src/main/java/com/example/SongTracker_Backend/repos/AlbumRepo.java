package com.example.SongTracker_Backend.repos;

import com.example.SongTracker_Backend.models.Album;
import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Table(name = "albums")
@Repository
public interface AlbumRepo extends JpaRepository<Album, Integer> {
}
