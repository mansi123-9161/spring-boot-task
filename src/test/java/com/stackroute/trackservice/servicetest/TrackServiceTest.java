package com.stackroute.trackservice.servicetest;

import com.stackroute.trackservice.domain.Track;
import com.stackroute.trackservice.exceptions.TrackAlreadyExistException;
import com.stackroute.trackservice.exceptions.TrackNotFoundException;
import com.stackroute.trackservice.repository.TrackRepository;
import com.stackroute.trackservice.service.TrackServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class TrackServiceTest {
    Track track;

    //Create a mock for UserRepository
    @Mock
    TrackRepository trackRepository;

    //Inject the mocks as dependencies into UserServiceImpl
    @InjectMocks
     private   TrackServiceImpl trackService;
    List<Track> list= null;


    @Before
    public void setUp(){
        //Initialising the mock object
        MockitoAnnotations.initMocks(this);
        track = new Track();
        track.set_id(12);
        track.setName("song12");
        track.setComments("comments12");
        list = new ArrayList<>();
        list.add(track);
    }
    @Test
    public void saveTrackSuccess() throws TrackAlreadyExistException {

        when(trackRepository.save((Track) any())).thenReturn(track);
        Track saveTrack = trackRepository.save(track);
        Assert.assertEquals(track, saveTrack);

        //verify here verifies that userRepository save method is only called once
        verify(trackRepository, times(1)).save(track);

    }
//    @Test
//    public void deleteTrackSuccess() throws TrackNotFoundException{
//
//        when(trackRepository.Track saveTrack = trackRepository.save(track);
//        Assert.assertEquals(track, saveTrack);
//
//        //verify here verifies that userRepository save method is only called once
//        verify(trackRepository, times(1)).save(track);
//
//    }

    @Test
    public void getAllTrack() {

        trackRepository.save(track);
        //stubbing the mock to return specific data
        when(trackRepository.findAll()).thenReturn(list);
        List<Track> tracks = trackRepository.findAll();
        Assert.assertEquals(list, tracks);
    }

    @Test(expected = TrackAlreadyExistException.class)
    public void saveTrackTestExistsAlready() throws TrackAlreadyExistException{
//        when(trackRepository.save(track)(any())).thenReturn(null);
        when(trackRepository.save((Track) any())).thenReturn(null);
        Track saveTrack = trackService.saveTrack(track);
        System.out.println("savedUser " + saveTrack);
        Assert.assertNotSame(track,saveTrack);

       /*doThrow(new UserAlreadyExistException()).when(userRepository).findById(eq(101));
       userService.saveUser(user);*/


    }
}
