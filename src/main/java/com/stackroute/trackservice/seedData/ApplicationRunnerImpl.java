package com.stackroute.trackservice.seedData;

import com.stackroute.trackservice.domain.Track;
import com.stackroute.trackservice.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationRunnerImpl implements ApplicationListener, ApplicationRunner {
    private TrackRepository trackRepository;
@Autowired
    public ApplicationRunnerImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }
//runs before server running to check connectivity
    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
     Track track1=new Track(1,"song1","comment1list");
     trackRepository.save(track1);
        Track track2=new Track(2,"song2","comment2");
        trackRepository.save(track2);
        Track track3=new Track(3,"song3","comment3");
        trackRepository.save(track3);
        Track track4=new Track(4,"song4","comment4");
        trackRepository.save(track4);
    }
    // it starts just after application context created
    @Override
    public void run(ApplicationArguments args) throws Exception {
        Track track1=new Track(1,"song1","comment1runner");
        trackRepository.save(track1);
        Track track2=new Track(2,"song2","comment2");
        trackRepository.save(track2);
        Track track3=new Track(3,"song3","comment3");
        trackRepository.save(track3);
        Track track4=new Track(4,"song4","comment4");
        trackRepository.save(track4);
    }
}
