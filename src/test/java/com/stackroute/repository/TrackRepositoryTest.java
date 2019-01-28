package com.stackroute.repository;

import com.stackroute.domain.Track;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataMongoTest
public class TrackRepositoryTest {

    @Autowired
    private TrackRepository trackRepository;
    private Track track;

    @Before
    public void setUp()
    {
        track = new Track();
        track.setTrackId(3);
        track.setTrackName("Alan Walker");
        track.setComments("favourite song");
    }

    @Test
    public void saveTrackTest()
    {
        trackRepository.save(track);
        Track fetchTrack = trackRepository.findById(track.getTrackId()).get();
        Assert.assertEquals(3,fetchTrack.getTrackId());
    }

    @Test
    public void getTrackTest()
    {
        Track track = new Track(4,"Shreya Goshal","Good");
        Track track1 = new Track(5,"DSP","Good");
        trackRepository.save(track);
        trackRepository.save(track1);
        List<Track> list = trackRepository.findAll();
        Assert.assertEquals(4,list.get(3).getTrackId());
    }

    @Test
    public void testSaveUserFailure(){
        Track testTrack = new Track(101,"fgf","gh");
        trackRepository.save(track);
        Track fetchUser = trackRepository.findById(track.getTrackId()).get();
        Assert.assertNotSame(testTrack,track);
    }


}
