package com.cyreno.service;

import com.cyreno.model.Command;
import com.cyreno.model.Robot;

public class RobotCommandExecutor {

    private static boolean debug = false;

    private final Robot robot;

    public RobotCommandExecutor(Robot robot) {
        this.robot = robot;
    }


    public void executeCommands(String commands) {
        for (char c : commands.toCharArray()) {
            executeCommand(c);
        }
    }

    private void executeCommand(char c) {

        Command command = Command.valueOf(c);

        switch (command) {
            case MOVE:
                robot.move();
                break;
            case TURN_LEFT:
                robot.turnLeft();
                break;
            case TURN_RIGHT:
                robot.turnRight();
                break;
        }

        printDebugInfo(command);

    }

    private void printDebugInfo(Command command) {
        if (debug) {
            System.out.println(command.name() + " -> " + RobotResponseFormatter.getResponseAsText(robot));
        }
    }

    public static void setDebug(boolean aDebug) {
        debug = aDebug;
    }

}
