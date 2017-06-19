package com.cyreno.model;

import com.cyreno.exception.InvalidCommandException;

import java.util.Arrays;

public enum Command {

    MOVE('M'), TURN_LEFT('L'), TURN_RIGHT('R');

    private char code;

    Command(char code) {
        this.code = code;
    }

    public static Command valueOf(char c) {
        return Arrays.stream(values())
                .filter(command -> command.code == c)
                .findFirst()
                .orElseThrow(InvalidCommandException::new);
    }

}
