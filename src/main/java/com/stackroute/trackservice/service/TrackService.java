package com.stackroute.trackservice.service;

import com.stackroute.trackservice.Exceptions.TrackAlreadyExistException;
import com.stackroute.trackservice.Exceptions.TrackNotFoundException;
import com.stackroute.trackservice.domain.Track;

import java.util.List;

public interface TrackService {
     Track getTrackById(int id) throws TrackAlreadyExistException;
     Track saveTrack(Track track) throws TrackAlreadyExistException, TrackNotFoundException;
     Track deleteTrackById(int id) throws TrackNotFoundException;
     Track updateTrack(int id,Track track);
     List<Track> getAllTrack();

    Track getTrackByName(String name);
}
