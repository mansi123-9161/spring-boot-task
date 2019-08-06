package com.stackroute.trackservice.repository;

import com.stackroute.trackservice.domain.Track;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrackRepository extends MongoRepository<Track, Integer> {
    //@Query is used to add custom query if needed
//   @Query(value = "select track from  Track track where track.name=?1 ")
   Track findByName(String name);
}
