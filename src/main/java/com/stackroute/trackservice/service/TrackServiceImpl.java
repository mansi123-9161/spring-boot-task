package com.stackroute.trackservice.service;

import com.stackroute.trackservice.domain.Track;
import com.stackroute.trackservice.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackServiceImpl implements TrackService {
    private TrackRepository trackRepository;

    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    //
    @Override
    public Track getTrackById(int id) {
        return trackRepository.findById(id).get();
    }

    @Override
    public Track saveTrack(Track track) {
        return trackRepository.save(track);
    }

    // method to delete track with particular id
    @Override
    public Track deleteTrackById(int id) {
        Optional<Track> value = trackRepository.findById(id);
        if (value.isPresent()) {
            trackRepository.deleteById(id);
            return value.get();
        } else
            return null;
    }

    @Override
    public Track updateTrack(int id, Track track) {
        //        delete the track
        trackRepository.deleteById(id);
//        edit the track and save it
        Track updateTrack = trackRepository.save(track);
        return updateTrack;
    }

    //method to find all tracks
    @Override
    public List<Track> getAllTrack() {
        return trackRepository.findAll();
    }

    @Override
    public Track getTrackByName(String name) {
        return trackRepository.findTrackByName(name);
    }

}
