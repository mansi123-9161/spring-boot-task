package com.stackroute.trackservice.service;

import com.stackroute.trackservice.domain.Track;

import java.util.List;

public interface TrackService {
     Track getTrackById(int id);
     Track saveTrack(Track track);
     Track deleteTrackById(int id);
     Track updateTrack(int id,Track track);
     List<Track> getAllTrack();

    Track getTrackByName(String name);
}
