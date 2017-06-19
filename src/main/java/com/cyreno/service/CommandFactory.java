package com.cyreno.service;

import com.cyreno.exception.InvalidCommandException;
import com.cyreno.model.command.Command;
import com.cyreno.model.command.MoveCommand;
import com.cyreno.model.command.TurnLeftCommand;
import com.cyreno.model.command.TurnRightCommand;

public class CommandFactory {

    public static Command getCommand(char c) {

        switch (c) {
            case 'M':
                return new MoveCommand();
            case 'L':
                return new TurnLeftCommand();
            case 'R':
                return new TurnRightCommand();
            default:
                throw new InvalidCommandException("Invalid Command: " + String.valueOf(c));
        }

    }

}
