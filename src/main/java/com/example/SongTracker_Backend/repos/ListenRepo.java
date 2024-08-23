package com.example.SongTracker_Backend.repos;

import com.example.SongTracker_Backend.models.Listen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListenRepo extends JpaRepository<Listen,Long> {
}
