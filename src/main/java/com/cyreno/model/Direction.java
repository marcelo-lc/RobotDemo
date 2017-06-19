package com.cyreno.model;

public enum Direction {

    NORTH("N"), EAST("E"), SOUTH("S"), WEST("W");

    private String code;

    Direction(String code) {
        this.code = code;
    }

    /**
     * The previous Direction in the anti-clockwise order:
     * <p>
     * |- N <- E <- S <- W <-|
     * |_____________________|
     */
    public Direction previous() {
        int position = ordinal() - 1 < 0 ? values().length - 1 : ordinal() - 1;
        return values()[position];
    }

    /**
     * The next Direction in the clockwise order:
     * <p>
     * |-> N -> E -> S -> W -|
     * |_____________________|
     */
    public Direction next() {
        int position = ordinal() + 1 >= values().length ? 0 : ordinal() + 1;
        return values()[position];
    }

    public String getCode() {
        return code;
    }

}
