package com.stackroute.trackservice.controllertest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.trackservice.controller.TrackController;
import com.stackroute.trackservice.domain.Track;
import com.stackroute.trackservice.exceptions.GlobalException;
import com.stackroute.trackservice.exceptions.TrackAlreadyExistException;
import com.stackroute.trackservice.exceptions.TrackNotFoundException;
import com.stackroute.trackservice.service.TrackService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest
public class TrackControllerTest {
    @Autowired
    private MockMvc mockMvc;
    private Track track;
    @MockBean
    private TrackService trackService;
    @InjectMocks
    private TrackController trackController;

    private List<Track> list = null;

    @Before
    public void setUp() {

        MockitoAnnotations.initMocks(this);
//        mockMvc = MockMvcBuilders.standaloneSetup(trackController).build();
        mockMvc = MockMvcBuilders.standaloneSetup(trackController).setControllerAdvice(new GlobalException()).build();
        track = new Track();
        track.set_id(10);
        track.setName("track");
        track.setComments("comment1");
        list = new ArrayList();

        list.add(track);
    }

    @Test
    public void saveTrack() throws Exception {
        when(trackService.saveTrack(any())).thenReturn(track);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/track")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(track)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andDo(MockMvcResultHandlers.print());


    }

    @Test
    public void getAllTracks() throws Exception {
        when(trackService.getAllTrack()).thenReturn(list);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/tracks")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(track)))
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andDo(MockMvcResultHandlers.print());

    }
    @Test
    public void getTrackByName() throws Exception {
        when(trackService.getTrackByName(track.getName())).thenReturn(track);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/tracks/name")
        .contentType(MediaType.APPLICATION_JSON).content(asJsonString(track)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }
    @Test
    public void getTrackById() throws Exception {
        when(trackService.getTrackById(10)).thenReturn(track);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/track/10")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(track)))
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andDo(MockMvcResultHandlers.print());
    }
    @Test
    public void getTrackByIdFailure() throws Exception {
        when(trackService.getTrackById(track.get_id())).thenThrow(TrackNotFoundException.class);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/tracks/name")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(track)))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andDo(MockMvcResultHandlers.print());
    }
    @Test
    public void saveTrackFailure() throws Exception {
        when(trackService.saveTrack(any())).thenThrow(TrackAlreadyExistException.class);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/track")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(track)))
                .andExpect(MockMvcResultMatchers.status().isConflict())
                .andDo(MockMvcResultHandlers.print());
    }



    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
