package com.cyreno.model;

import com.cyreno.exception.OutOfBoundsException;
import org.junit.Before;
import org.junit.Test;

import static com.cyreno.model.Direction.*;
import static com.cyreno.service.RobotResponseFormatter.getResponseAsText;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class RobotTest {

    private Surface surface;

    @Before
    public void setUp() throws Exception {
        surface = new Surface(5, 5);
    }

    @Test(expected = OutOfBoundsException.class)
    public void testDeployOutOfBounds() throws Exception {
        Robot robot = new Robot(5, 4, NORTH, surface);
    }

    @Test(expected = OutOfBoundsException.class)
    public void testMoveUntilOutOfBounds() throws Exception {
        Robot robot = new Robot(5, 4, NORTH, surface);

        while (true) {
            robot.move();
        }
    }

    @Test
    public void testRegularMovesToNorth() throws Exception {

        Robot robot = new Robot(0, 0, NORTH, surface);
        robot.move();
        robot.move();

        assertThat(getResponseAsText(robot), is(getResponseAsText(0, 2, NORTH)));

    }

    @Test
    public void testRegularMovesToSouth() throws Exception {

        Robot robot = new Robot(4, 4, SOUTH, surface);
        robot.move();
        robot.move();

        assertThat(getResponseAsText(robot), is(getResponseAsText(4, 2, SOUTH)));

    }

    @Test
    public void testRegularMovesToEast() throws Exception {

        Robot robot = new Robot(0, 0, EAST, surface);
        robot.move();
        robot.move();

        assertThat(getResponseAsText(robot), is(getResponseAsText(2, 0, EAST)));

    }

    @Test
    public void testRegularMovesToWest() throws Exception {

        Robot robot = new Robot(4, 0, WEST, surface);
        robot.move();
        robot.move();

        assertThat(getResponseAsText(robot), is(getResponseAsText(2, 0, WEST)));

    }


    @Test
    public void testTurnLeft() throws Exception {

        Robot robot = new Robot(0, 0, NORTH, surface);

        robot.turnLeft();
        assertThat(robot.getDirection(), is(equalTo(WEST)));

        robot.turnLeft();
        assertThat(robot.getDirection(), is(equalTo(SOUTH)));

        robot.turnLeft();
        assertThat(robot.getDirection(), is(equalTo(EAST)));

        robot.turnLeft();
        assertThat(robot.getDirection(), is(equalTo(NORTH)));

    }

    @Test
    public void testTurnRight() throws Exception {

        Robot robot = new Robot(0, 0, NORTH, surface);

        robot.turnRight();
        assertThat(robot.getDirection(), is(equalTo(EAST)));

        robot.turnRight();
        assertThat(robot.getDirection(), is(equalTo(SOUTH)));

        robot.turnRight();
        assertThat(robot.getDirection(), is(equalTo(WEST)));

        robot.turnRight();
        assertThat(robot.getDirection(), is(equalTo(NORTH)));

    }

}