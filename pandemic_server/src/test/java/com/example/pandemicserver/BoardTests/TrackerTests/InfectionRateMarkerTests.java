package com.example.pandemicserver.BoardTests.TrackerTests;

import models.board.trackers.InfectionRateMarker;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class InfectionRateMarkerTests {

    InfectionRateMarker infectionRateMarker;

    @Before
    public void before() {
        infectionRateMarker = new InfectionRateMarker();
    }

    @Test
    public void beginsAtPositionZeroWithTwoCards() {
        assertEquals(0, infectionRateMarker.getPosition());
        assertEquals(2, infectionRateMarker.getCardsToDraw());
    }
}
