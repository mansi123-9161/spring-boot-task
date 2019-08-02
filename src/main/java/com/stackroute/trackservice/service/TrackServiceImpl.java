package com.stackroute.trackservice.service;

import com.stackroute.trackservice.domain.Track;
import com.stackroute.trackservice.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackServiceImpl implements TrackService{
    private TrackRepository trackRepository;
   @Autowired
    public TrackServiceImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public Track getTrackById(int id) {
      return trackRepository.findById(id).get();
    }

    @Override
    public Track getTrackSave(Track track) {
        return trackRepository.save(track);
    }

    @Override
    public Track deleteTrackById(int id) {
     Optional<Track> value= trackRepository.findById(id);
      trackRepository.deleteById(id);
     return value.get();
    }

    @Override
    public Track updateTrack(int id, Track track) {
       Optional<Track> value=trackRepository.findById(id);
       trackRepository.save(track);
        return null;
    }

    @Override
    public List<Track> getAllTrack() {
        return trackRepository.findAll();
    }


}
