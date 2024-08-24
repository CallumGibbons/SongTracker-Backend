package com.example.SongTracker_Backend.Services;

import com.example.SongTracker_Backend.Exceptions.AlbumNotFoundException;
import com.example.SongTracker_Backend.models.Album;
import com.example.SongTracker_Backend.repos.AlbumRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AlbumService {

    @Autowired
    private AlbumRepo albumRepo;

    // Get all albums
    public List<Album> getAllAlbums() {
        return albumRepo.findAll();
    }

    // Get a specific album by album_id
    public Album getAlbumById(Integer album_id) {
        return albumRepo.findById(album_id)
                .orElseThrow(() -> new AlbumNotFoundException(album_id));
    }

    // Add a new album
    public Album createAlbum(Album newAlbum) {
        return albumRepo.save(newAlbum);
    }

    // Update a specific album by album_id
    @Transactional
    public Album updateAlbum(Integer album_id, Album newAlbum) {
        return albumRepo.findById(album_id)
                .map(album -> {
                    album.setName(newAlbum.getName());
                    album.set_favourite(newAlbum.is_favourite());
                    album.setArtist(newAlbum.getArtist());
                    album.setListens(newAlbum.getListens());
                    album.setSongs(newAlbum.getSongs());
                    return albumRepo.save(album);
                })
                .orElseGet(() -> {
                    newAlbum.setAlbum_id(album_id); // Set the ID to the provided path variable
                    return albumRepo.save(newAlbum);
                });
    }

    // Delete a specific album by album_id
    @Transactional
    public void deleteAlbum(Integer album_id) {
        albumRepo.deleteById(album_id);
    }
}
