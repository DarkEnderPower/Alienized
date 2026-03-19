package com.darkenderhilda.alienized.foundation.ui.utils;

public class Area {

    private float x;
    private float y;
    private float width;
    private float height;

    public Area(float x, float y, float width, float height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public Area() {
        this(0, 0, 0, 0);
    }

    public Area(float width, float height) {
        this(0, 0, width, height);
    }

    public Area(Area a) {
        this(a.getX(), a.getY(), a.getWidth(), a.getHeight());
    }
    
    public Area(Point p) {
        this(p.getX(), p.getY(), 0, 0);
    }
    
    public Area(Dimension d) {
        this(d.getWidth(), d.getHeight());
    }
    
    public Area(Point p, Dimension d) {
        this(p.getX(), p.getY(), d.getWidth(), d.getHeight());
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public Point getCenter() {
        return new Point(x + width / 2, y + height / 2);
    }
    
    public Area getBounds() {
        return new Area(this);
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public void setHeight(float height) {
        this.height = height;
    }
    
    public void setLocation(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void setLocation(Point p) {
        setLocation(p.getX(), p.getY());
    }

    public void setSize(Dimension d) {
        setSize(d.getWidth(), d.getHeight());
    }

    public void setSize(float width, float height) {
        this.width = width;
        this.height = height;
    }
    
    public void setBounds(float x, float y, float width, float height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void setBounds(Area a) {
        setBounds(a.getX(), a.getY(), a.getWidth(), a.getHeight());
    }

    public Point getLocation() {
        return new Point(x, y);
    }
    
    public Dimension getSize() {
        return new Dimension(width, height);
    }

    public void translate(float dx, float dy) {
        x += dx;
        y += dy;
    }

    public boolean contains(float X, float Y) {
        float w = this.width;
        float h = this.height;
        if (w < 0  || h < 0) {
            return false;
        }

        float x = this.x;
        float y = this.y;
        if (X < x || Y < y) {
            return false;
        }
        w += x;
        h += y;

        return ((w < x || w > X) &&
                (h < y || h > Y));

    }

    public boolean contains(Point p) {
        return contains(p.getX(), p.getY());
    }

    public boolean interact(Area r) {
        float tw = this.width;
        float th = this.height;
        float rw = r.width;
        float rh = r.height;
        if (rw <= 0 || rh <= 0 || tw <= 0 || th <= 0) {
            return false;
        }
        float tx = this.x;
        float ty = this.y;
        float rx = r.x;
        float ry = r.y;
        rw += rx;
        rh += ry;
        tw += tx;
        th += ty;

        return ((rw < rx || rw > tx) &&
                (rh < ry || rh > ty) &&
                (tw < tx || tw > rx) &&
                (th < ty || th > ry));
    }

    public Area intersection(Area r) {
        float tx1 = this.x;
        float ty1 = this.y;
        float rx1 = r.x;
        float ry1 = r.y;
        float tx2 = tx1; tx2 += this.width;
        float ty2 = ty1; ty2 += this.height;
        float rx2 = rx1; rx2 += r.width;
        float ry2 = ry1; ry2 += r.height;
        if (tx1 < rx1) tx1 = rx1;
        if (ty1 < ry1) ty1 = ry1;
        if (tx2 > rx2) tx2 = rx2;
        if (ty2 > ry2) ty2 = ry2;
        tx2 -= tx1;
        ty2 -= ty1;

        return new Area(tx1, ty1,  tx2,  ty2);
    }

    public Area union(Area r) {
        float tx2 = this.width;
        float ty2 = this.height;
        if (tx2 < 0 || ty2 < 0) {
            return new Area(r);
        }
        float rx2 = r.width;
        float ry2 = r.height;
        if (rx2 < 0 || ry2 < 0) {
            return new Area(this);
        }
        float tx1 = this.x;
        float ty1 = this.y;
        tx2 += tx1;
        ty2 += ty1;
        float rx1 = r.x;
        float ry1 = r.y;
        rx2 += rx1;
        ry2 += ry1;
        if (tx1 > rx1) tx1 = rx1;
        if (ty1 > ry1) ty1 = ry1;
        if (tx2 < rx2) tx2 = rx2;
        if (ty2 < ry2) ty2 = ry2;
        tx2 -= tx1;
        ty2 -= ty1;

        return new Area(tx1, ty1,  tx2,  ty2);
    }

    public void grow(float v, float h) {
        x -= v;
        width += v * 2;
        y -= h;
        height += h * 2;
    }

    public void shrink(float v, float h) {
        x += v;
        width -= v * 2;
        y += h;
        height -= h * 2;
    }
}
