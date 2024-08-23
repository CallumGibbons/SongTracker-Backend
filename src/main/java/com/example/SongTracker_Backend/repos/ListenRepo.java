package com.example.SongTracker_Backend.repos;

import com.example.SongTracker_Backend.models.Listen;
import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Table(name = "listening_history")
@Repository
public interface ListenRepo extends JpaRepository<Listen,Integer> {
}
