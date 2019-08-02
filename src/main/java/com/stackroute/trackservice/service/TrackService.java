package com.stackroute.trackservice.service;

import com.stackroute.trackservice.domain.Track;

import java.util.List;

public interface TrackService {
    public Track getTrackById(int id);
    public Track getTrackSave(Track track);
    public Track deleteTrackById(int id);
    public Track updateTrack(int id,Track track);
    public List<Track> getAllTrack();
}
