package com.stackroute.trackservice.service;

import com.stackroute.trackservice.exceptions.TrackAlreadyExistException;
import com.stackroute.trackservice.exceptions.TrackNotFoundException;
import com.stackroute.trackservice.domain.Track;
import com.stackroute.trackservice.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
//@Profile("prod")
@Service
//Primary annotation is used to give higher preference to a bean when there are multiple beans of the same type.
//@Primary
//In Spring, @Qualifier means, which bean is qualify to autowired on a field.
//@Qualifier("main")
public class TrackServiceImpl implements TrackService {
    private TrackRepository trackRepository;

    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    //
    @Override
    public Track getTrackById(int id) throws TrackAlreadyExistException {

        if(trackRepository.existsById(id)){
                throw new TrackAlreadyExistException("track is already added before");
        }
            return trackRepository.findById(id).get();
    }

    @Override
    public Track saveTrack(Track track) throws TrackNotFoundException {
        if(trackRepository.existsById(track.getId())) {
                throw new TrackNotFoundException("track is not present");
        }
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
          // edit the track and save it
        Track updateTrack = trackRepository.save(track);
        return updateTrack;
    }

    //method to find all tracks
    @Override
    public List<Track> getAllTrack() {
        return trackRepository.findAll();
    }
     //method to get track by their name
   /* @Override
    public Track getTrackByName(String name) {
        return trackRepository.findTrackByName(name);
    }*/

}
