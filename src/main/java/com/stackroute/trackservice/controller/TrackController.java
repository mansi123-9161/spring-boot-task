package com.stackroute.trackservice.controller;

import com.stackroute.trackservice.domain.Track;
import com.stackroute.trackservice.service.TrackService;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value ="api/v1")
public class TrackController {
    private TrackService trackService;

    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }
    //get track bt id method
    @GetMapping("track/{id}")
    public ResponseEntity<?> getTrackById(@PathVariable int id){
        ResponseEntity responseEntity;
        try {
           trackService.getTrackById(id);
            responseEntity = new ResponseEntity("created", HttpStatus.CREATED);
        } catch (Exception ex) {
            responseEntity = new ResponseEntity(ex.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
    @PostMapping("track")
    public ResponseEntity<?> getTrackSave(@RequestBody Track track){
        ResponseEntity responseEntity;
        try {
            trackService.getTrackSave(track);
            responseEntity = new ResponseEntity("created", HttpStatus.CREATED);
        } catch (Exception ex) {
            responseEntity = new ResponseEntity(ex.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
    @GetMapping("track")
    public ResponseEntity<?> getAllTrack(){
        ResponseEntity responseEntity;
        try {
            trackService.getAllTrack();
            responseEntity = new ResponseEntity("created", HttpStatus.CREATED);
        } catch (Exception ex) {
            responseEntity = new ResponseEntity(ex.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
    @DeleteMapping("track/{id}")
    public ResponseEntity<?> deleteTrackById(@PathVariable int id){
        ResponseEntity responseEntity;
        try {
            trackService.deleteTrackById(id);
            responseEntity = new ResponseEntity("success", HttpStatus.CREATED);
        } catch (Exception ex) {
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
}
