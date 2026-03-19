package com.darkenderhilda.alienized.foundation.ui.utils;

public class Dimension {

    private float width;
    private float height;


    public Dimension(float width, float height) {
        this.width = width;
        this.height = height;
    }

    public Dimension() {
        this(0, 0);
    }

    public Dimension(Dimension d) {
        this(d.getWidth(), d.getHeight());}

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public Dimension getSize() {
        return new Dimension(this);
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setSize(float width, float height) {
        this.width = width;
        this.height = height;
    }

    public void setSize(Dimension d) {
        setSize(d.getWidth(), d.getHeight());
    }

    public void expand(float widthX, float heightX) {
        width += widthX;
        height += heightX;
    }
}
