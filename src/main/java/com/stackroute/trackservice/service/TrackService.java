package com.stackroute.trackservice.service;

import com.stackroute.trackservice.exceptions.TrackAlreadyExistException;
import com.stackroute.trackservice.exceptions.TrackNotFoundException;
import com.stackroute.trackservice.domain.Track;

import java.util.List;

public interface TrackService {
     //to get track by a particular id
     Track getTrackById(int id) throws TrackAlreadyExistException;
     //    to save a track and trow exception message if same track already present
     Track saveTrack(Track track) throws TrackAlreadyExistException, TrackNotFoundException;
     //to delete a particular track by id and throw exception if already deleted
     Track deleteTrackById(int id) throws TrackNotFoundException;
     //to update track and throw exception if already exists
     Track updateTrack(int id,Track track);
     //    to get all the tracks
     List<Track> getAllTrack();

//    Track getTrackByName(String name);
}
