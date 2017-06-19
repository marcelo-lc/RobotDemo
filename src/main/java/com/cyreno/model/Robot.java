package com.cyreno.model;

import com.cyreno.exception.OutOfBoundsException;

public class Robot {

    private final Surface surface;
    private Coordinate coordinate;

    public Robot(int x, int y, Direction direction, Surface surface) {

        if (!surface.contains(x, y)) {
            throw new OutOfBoundsException();
        }

        this.coordinate = new Coordinate(x, y, direction);
        this.surface = surface;

    }

    public void move() {

        int newX = coordinate.getX();
        int newY = coordinate.getY();

        switch (coordinate.getDirection()) {
            case NORTH:
                newY++;
                break;
            case SOUTH:
                newY--;
                break;
            case WEST:
                newX--;
                break;
            case EAST:
                newX++;
                break;
        }

        if (!surface.contains(newX, newY)) {
            throw new OutOfBoundsException();
        }

        coordinate.setX(newX);
        coordinate.setY(newY);

    }

    public Direction turnLeft() {
        coordinate.setDirection(coordinate.getDirection().previous());
        return coordinate.getDirection();
    }

    public Direction turnRight() {
        coordinate.setDirection(coordinate.getDirection().next());
        return coordinate.getDirection();
    }

    public int getX() {
        return coordinate.getX();
    }

    public int getY() {
        return coordinate.getY();
    }

    public Direction getDirection() {
        return coordinate.getDirection();
    }

    @Override
    public String toString() {
        return "Robot{" +
                "surface=" + surface +
                ", coordinate=" + coordinate +
                '}';
    }

}
