package com.cyreno.model.command;

import com.cyreno.model.Robot;

public class MoveCommand implements Command {

    @Override
    public void execute(Robot robot) {
        robot.move();
    }

}
