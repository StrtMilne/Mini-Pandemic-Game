package com.example.pandemicserver.BoardTests.TrackerTests;

import models.board.trackers.OutbreakMarker;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class OutbreakMarkerTests {

    OutbreakMarker outBreakMarker;

    @Before
    public void before() {
        outBreakMarker = new OutbreakMarker();
    }

    @Test
    public void valueStartsAtZero() {
        assertEquals(0, outBreakMarker.getPosition());
    }
}
