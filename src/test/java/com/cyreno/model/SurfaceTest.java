package com.cyreno.model;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class SurfaceTest {

    @Test
    public void testCoordinatesInsideSurface() throws Exception {

        Surface surface = new Surface(5, 5);

        for (int x = 0; x < surface.getWidth(); x++) {
            for (int y = 0; y < surface.getHeight(); y++) {
                assertThat(surface.contains(x, y), equalTo(true));
            }
        }

    }

    @Test
    public void testCoordinatesOutOfBounds() throws Exception {

        Surface surface = new Surface(5, 5);

        assertThat(surface.contains(-1, 0), equalTo(false));
        assertThat(surface.contains(0, -1), equalTo(false));
        assertThat(surface.contains(-1, -1), equalTo(false));

        assertThat(surface.contains(surface.getWidth(), 0), equalTo(false));
        assertThat(surface.contains(0, surface.getHeight()), equalTo(false));
        assertThat(surface.contains(surface.getWidth(), surface.getHeight()), equalTo(false));

    }

}