package com.cyreno.service;

import com.cyreno.model.Direction;
import com.cyreno.model.Robot;

public class RobotResponseFormatter {

    public static String getResponseAsText(Robot robot) {
        return getResponseAsText(robot.getX(), robot.getY(), robot.getDirection());
    }

    public static String getResponseAsText(int x, int y, Direction direction) {
        return String.format("(%d, %d, %s)", x, y, direction.getCode());
    }

}
