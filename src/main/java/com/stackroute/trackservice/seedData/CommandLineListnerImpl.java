package com.stackroute.trackservice.seedData;

import com.stackroute.trackservice.domain.Track;
import com.stackroute.trackservice.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineListnerImpl implements CommandLineRunner {
    private TrackRepository trackRepository;
@Autowired
// it starts just after application context created
    public CommandLineListnerImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Track track1=new Track(1,"song1","comment1list");
        trackRepository.save(track1);
        Track track2=new Track(2,"song2","comment2");
        trackRepository.save(track2);
        Track track3=new Track(3,"song3","comment3");
        trackRepository.save(track3);
        Track track4=new Track(4,"song4","comment4");
        trackRepository.save(track4);
    }
}
