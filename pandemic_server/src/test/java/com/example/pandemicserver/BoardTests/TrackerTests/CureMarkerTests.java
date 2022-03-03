package com.example.pandemicserver.BoardTests.TrackerTests;

import models.board.trackers.CureMarkers;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class CureMarkerTests {

    CureMarkers curemarkers;

    @Before
    public void before() {
        curemarkers = new CureMarkers();
    }

    @Test
    public void markersStartAsFalse() {
        assertEquals(false, curemarkers.isBlue());
        assertEquals(false, curemarkers.isYellow());
        assertEquals(false, curemarkers.isRed());
        assertEquals(false, curemarkers.isBlack());
    }

}
