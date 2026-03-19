package com.darkenderhilda.alienized.foundation.ui.utils;

public class Point {

    private float x;
    private float y;

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
        this(0, 0);
    }

    public Point(Point p) {
        this(p.getX(), p.getY());
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public Point getPos() {
        return new Point(this);
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setLocation(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void setLocation(Point p) {
        setX(p.getX());
        setY(p.getY());
    }

    public void translate(float dx, float dy) {
        x += dx;
        y += dy;
    }
}
