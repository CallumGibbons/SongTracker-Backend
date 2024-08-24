package com.example.SongTracker_Backend.Services;

import com.example.SongTracker_Backend.Exceptions.SongNotFoundException;
import com.example.SongTracker_Backend.models.Song;
import com.example.SongTracker_Backend.repos.SongRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SongService {

    @Autowired
    private SongRepo songRepo;

    public List<Song> getAllSongs() {
        return songRepo.findAll();
    }

    public Song getSongById(Integer song_id) {
        return songRepo.findById(song_id)
                .orElseThrow(() -> new SongNotFoundException(song_id));
    }

    public Song saveSong(Song newSong) {
        return songRepo.save(newSong);
    }

    public Song updateSong(Song newSong, Integer song_id) {
        return songRepo.findById(song_id)
                .map(song -> {
                    song.setName(newSong.getName());
                    song.setAlbum(newSong.getAlbum());
                    song.setArtist(newSong.getArtist());
                    song.set_favourite(newSong.isIs_favourite());
                    song.setListens(newSong.getListens());
                    return songRepo.save(song);
                })
                .orElseGet(() -> {
                    newSong.setSong_id(song_id);
                    return songRepo.save(newSong);
                });
    }

    @Transactional
    public void deleteSongById(Integer song_id) {
        if (!songRepo.existsById(song_id)) {
            throw new SongNotFoundException(song_id);
        }
        songRepo.deleteById(song_id);
    }
}
