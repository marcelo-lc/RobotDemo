package com.cyreno.model;

public class Surface {

    private int width;
    private int height;

    public Surface(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean contains(int x, int y) {
        return x >= 0 && x < getWidth() && y >= 0 && y < getHeight();
    }

    @Override
    public String toString() {
        return "Surface{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }
}
