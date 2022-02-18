package com.example.pandemicserver.BoardTests;

import models.board.Cube;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class CubeTests {

    @Test
    public void cubeHasColour() {
        Cube cube = new Cube("red");
        assertEquals("red", cube.getColour());
    }

}
