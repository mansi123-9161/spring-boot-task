package com.stackroute.trackservice.repositoryTest;

import com.stackroute.trackservice.domain.Track;
import com.stackroute.trackservice.repository.TrackRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@DataMongoTest
public class TrackRepositoryTest {
    @Autowired
    TrackRepository trackRepository;
    Track track;
    @Before
    public void setUp()
    {
        track = new Track();
        track.set_id(1);
        track.setName("song1");
        track.setComments("comments1");

    }

    @After
    public void tearDown() {

        trackRepository.deleteAll();
    }
   @Test
    public void testSaveUser(){
        Track track=new Track(2,"song2","comment2");
        trackRepository.save(track);
        List<Track> list=trackRepository.findAll();
        List<Track> expected=new ArrayList<>();
        expected.add(track);
        Assert.assertEquals(expected,list);

    }
    @Test
    public void testSaveUserFailure(){
        Track testUser = new Track(1,"SONG2","COMMENTS");
        trackRepository.save(track);
        Track fetchUser = trackRepository.findById(track.get_id()).get();
        Assert.assertNotSame(testUser,track);
    }
    @Test
    public void testGetByIdTrack(){
        trackRepository.save(track);
        Track testId=trackRepository.findById(track.get_id()).get();
        Assert.assertEquals(1,testId.get_id());
    }
    @Test
    public void testToGetByNotIdTrack(){
        Track testUser = new Track(1,"SONG2","COMMENTS");
        trackRepository.save(track);
        Track testId=trackRepository.findById(track.get_id()).get();
        Assert.assertNotSame(2,testId.get_id());
    }
    @Test
    public void testGetByNameTrack(){
        trackRepository.save(track);
        Track testId=trackRepository.findByName(track.getName());
        Assert.assertEquals(track,testId);
    }
    @Test
    public void testGetByNotNameTrack(){
        trackRepository.save(track);
        Track testId=trackRepository.findByName(track.getName());
        Assert.assertNotSame(track,testId);
    }

}
