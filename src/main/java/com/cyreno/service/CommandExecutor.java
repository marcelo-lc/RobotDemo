package com.cyreno.service;

import com.cyreno.model.Robot;

public class CommandExecutor {

    private static boolean debug = false;

    private final Robot robot;

    public CommandExecutor(Robot robot) {
        this.robot = robot;
    }

    public void executeCommands(String commandsText) {
        for (char c : commandsText.toCharArray()) {
            executeCommand(c);
        }
    }

    private void executeCommand(char commandCode) {
        CommandFactory.getCommand(commandCode).execute(robot);
        printDebugInfo(commandCode);
    }

    private void printDebugInfo(char c) {
        if (debug) {
            System.out.println(c + " -> " + RobotResponseFormatter.getResponseAsText(robot));
        }
    }

    public static void setDebug(boolean aDebug) {
        debug = aDebug;
    }

}
