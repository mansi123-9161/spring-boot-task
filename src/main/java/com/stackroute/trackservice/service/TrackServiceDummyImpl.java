package com.stackroute.trackservice.service;

import com.stackroute.trackservice.domain.Track;
import com.stackroute.trackservice.exceptions.TrackAlreadyExistException;
import com.stackroute.trackservice.exceptions.TrackNotFoundException;
import com.stackroute.trackservice.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
@Profile("dev")
@Service
@Qualifier("dummy")
public class TrackServiceDummyImpl implements TrackService{
    private TrackRepository trackRepository;
  @Autowired
    public TrackServiceDummyImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public Track getTrackById(int id) throws TrackAlreadyExistException {
        return null;
    }

    @Override
    public Track saveTrack(Track track) throws TrackAlreadyExistException{
        return null;
    }

    @Override
    public Track deleteTrackById(int id) throws TrackNotFoundException {
        return null;
    }

    @Override
    public Track updateTrack(int id, Track track) {
        return null;
    }

    @Override
    public List<Track> getAllTrack() {
        return null;
    }

    @Override
    public Track getTrackByName(String name) {
        return null;
    }
}
