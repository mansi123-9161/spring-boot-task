package com.stackroute.trackservice.controller;

import com.stackroute.trackservice.exceptions.TrackAlreadyExistException;
import com.stackroute.trackservice.exceptions.TrackNotFoundException;
import com.stackroute.trackservice.domain.Track;
import com.stackroute.trackservice.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value ="api/v1/")
public class TrackController {
    private TrackService trackService;

    @Autowired
    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }

    //get track bt id method
    @GetMapping("track/{id}")
    public ResponseEntity<?> getTrackById(@PathVariable int id){
        ResponseEntity responseEntity;
        try {
           Track retrievedTrack = trackService.getTrackById(id);
            responseEntity = new ResponseEntity<Track>(retrievedTrack, HttpStatus.FOUND);
        } catch (Exception ex) {
            responseEntity = new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }
    @PostMapping("track")
    public ResponseEntity<?> saveTrack(@RequestBody Track track) throws TrackNotFoundException {
        ResponseEntity responseEntity;
        try {
            Track savedTrack = trackService.saveTrack(track);
            responseEntity = new ResponseEntity(savedTrack, HttpStatus.CREATED);
        } catch (TrackAlreadyExistException ex) {
            responseEntity = new ResponseEntity(ex.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
    @GetMapping("tracks")
    public ResponseEntity<?> getAllTracks(){
        ResponseEntity responseEntity;
        try {
            List<Track> listOfTracks= trackService.getAllTrack();
            responseEntity = new ResponseEntity(listOfTracks, HttpStatus.FOUND);
        } catch (Exception ex) {
            responseEntity = new ResponseEntity(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @DeleteMapping("track/{id}")
    public ResponseEntity<?> deleteTrackById(@PathVariable int id){
        ResponseEntity responseEntity;
        try {
            trackService.deleteTrackById(id);
            responseEntity = new ResponseEntity("success", HttpStatus.NOT_FOUND);
        } catch (TrackNotFoundException ex) {
            responseEntity = new ResponseEntity(ex.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
    @PostMapping("track/{id}")
    public ResponseEntity<?> updateTrack(@PathVariable int id,@RequestBody Track track){
        ResponseEntity responseEntity;
        try {
            trackService.updateTrack(id,track);
            responseEntity = new ResponseEntity(track, HttpStatus.CREATED);
        } catch (Exception ex) {
            responseEntity = new ResponseEntity(ex.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
//    //get track by name
    @GetMapping("tracks/{name}")
    public ResponseEntity<Track> getTrackByName(@PathVariable String name) {
        System.out.println("Name****" + name);
        ResponseEntity responseEntity;
        try {
           Track data= trackService.getTrackByName(name);
           responseEntity=new ResponseEntity<Track>(data,HttpStatus.OK);
        }
        catch (Exception ex){
            responseEntity =new ResponseEntity<>(ex.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

}
