package com.example.SongTracker_Backend.Services;

import com.example.SongTracker_Backend.Exceptions.ArtistNotFoundException;
import com.example.SongTracker_Backend.models.Artist;
import com.example.SongTracker_Backend.repos.ArtistRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistService {

    @Autowired
    private ArtistRepo artistRepo;

    // Get all artists
    public List<Artist> getAllArtists() {
        return artistRepo.findAll();
    }

    // Get a specific artist by artist_id
    public Artist getArtistById(Integer artist_id) {
        return artistRepo.findById(artist_id)
                .orElseThrow(() -> new ArtistNotFoundException(artist_id));
    }

    // Add a new artist
    public Artist createArtist(Artist newArtist) {
        return artistRepo.save(newArtist);
    }

    // Update a specific artist by artist_id
    @Transactional
    public Artist updateArtist(Integer artist_id, Artist newArtist) {
        return artistRepo.findById(artist_id)
                .map(artist -> {
                    artist.setName(newArtist.getName());
                    artist.set_favourite(newArtist.is_favourite());
                    artist.setAlbums(newArtist.getAlbums());
                    artist.setListens(newArtist.getListens());
                    return artistRepo.save(artist);
                })
                .orElseGet(() -> {
                    newArtist.setArtist_id(artist_id); // Set the ID to the provided path variable
                    return artistRepo.save(newArtist);
                });
    }

    // Delete a specific artist by artist_id
    @Transactional
    public void deleteArtist(Integer artist_id) {
        artistRepo.deleteById(artist_id);
    }
}
