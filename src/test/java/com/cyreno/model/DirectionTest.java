package com.cyreno.model;

import org.junit.Test;

import static com.cyreno.model.Direction.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class DirectionTest {

    @Test
    public void previous() throws Exception {
        assertThat(NORTH.previous(), is(equalTo(WEST)));
        assertThat(WEST.previous(), is(equalTo(SOUTH)));
        assertThat(SOUTH.previous(), is(equalTo(EAST)));
        assertThat(EAST.previous(), is(equalTo(NORTH)));
    }

    @Test
    public void next() throws Exception {
        assertThat(NORTH.next(), is(equalTo(EAST)));
        assertThat(EAST.next(), is(equalTo(SOUTH)));
        assertThat(SOUTH.next(), is(equalTo(WEST)));
        assertThat(WEST.next(), is(equalTo(NORTH)));
    }

}