package com.example.SongTracker_Backend.Services;

import com.example.SongTracker_Backend.models.Album;
import com.example.SongTracker_Backend.models.Artist;
import com.example.SongTracker_Backend.models.Song;
import com.example.SongTracker_Backend.repos.AlbumRepo;
import com.example.SongTracker_Backend.repos.ArtistRepo;
import com.example.SongTracker_Backend.repos.SongRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class SongService {

    @Autowired
    private SongRepo songRepo;

    @Autowired
    private AlbumRepo albumRepo;

    @Autowired
    private ArtistRepo artistRepo;

    @Transactional
    public void deleteSongByName(Long song_id) {
        Optional<Song> optionalSong = songRepo.findById(song_id);

        if (optionalSong.isPresent()) {
            Song song = optionalSong.get();
            Album album = song.getAlbum();
            Artist artist = song.getArtist();

            album.setListens(album.getListens() - song.getListens());
            artist.setListens(artist.getListens() - song.getListens());

            albumRepo.save(album);
            artistRepo.save(artist);

            songRepo.delete(song);
        } else {
            throw new RuntimeException("Song not found: " + song_id);
        }
    }
}
