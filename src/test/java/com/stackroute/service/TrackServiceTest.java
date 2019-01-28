package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.exception.AlreadyUpdatedException;
import com.stackroute.exception.TrackAlreadyExistException;
import com.stackroute.exception.TrackNotFoundException;
import com.stackroute.repository.TrackRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;


import static org.mockito.Mockito.*;

public class TrackServiceTest {
    Track track;

    @Mock
    TrackRepository trackRepository;

    @InjectMocks
    TrackServiceImpl trackService;
    List<Track> list = null;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        track = new Track();
        track.setTrackId(11);
        track.setTrackName("Rihana");
        track.setComments("Good song");
        list = new ArrayList<>();
        list.add(track);
    }


    @Test
    public void saveTrackTest() throws TrackAlreadyExistException
    {
        when(trackRepository.save((Track)any())).thenReturn(track);
        Track savedTrack = trackService.saveTrack(track);
        Assert.assertEquals(track,savedTrack);
    }

    @Test
    public void getTrackTest()
    {
        trackRepository.save(track);
        when(trackRepository.findAll()).thenReturn(list);
        List<Track> trackList = trackService.getTrack();
        Assert.assertEquals(list,trackList);
    }

    @Test
    public void updateTrackTest() throws AlreadyUpdatedException
    {
        when(trackRepository.save((Track)any())).thenReturn(track);
        Track updateTrack = null;
        try {
            updateTrack = trackService.saveTrack(track);
        } catch (TrackAlreadyExistException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(track,updateTrack);
    }

    /*@Test
    public boolean removeTrackTest(int id) throws TrackNotFoundException
    {
        boolean status = false;
        if (trackRepository.existsById(id)) {
            trackRepository.deleteById(id);
            status = true;
            return status;
        } else {

            throw new TrackNotFoundException("Track not found");

        }
    }*/





}
