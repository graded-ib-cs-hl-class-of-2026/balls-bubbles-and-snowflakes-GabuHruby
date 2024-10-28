class Bubble {

    /*
     * this class will represent a bubble that moves around the screen and pops when
     * it reaches a side
     */

    /** The sketch that the bubble is inside of */
    private Sketch s;
    /** the radius of the bubble */
    private float radius;
    private float x;
    private float y;
    /** The number of pixels the bubble moves right per frame */
    private float xSpeed;
    /** The number of pixels the bubble moves down per frame */
    private float ySpeed;
    /** The color of the inside of the bubble */
    private int fillColor;
    /** The color of the outside of the bubble */
    private int borderColor;

    /**
     * Fully specified constructor to allow changes to size, position, speed of the
     * bubble
     */
    public Bubble(Sketch sketch, float radius, float x, float y, float xspeed, float yspeed) {
        this.s = sketch;
        this.radius = radius;
        this.x = x;
        this.y = y;
        this.xSpeed = xspeed;
        this.ySpeed = yspeed;
    }

    // setting colors
    public void setColors(int fill, int border) {
        fillColor = fill;
        borderColor = border;
    }

    // accessors for the radius, diameter, x, and y values
    public float getRadius() {
        return radius;
    }

    public float getDiameter() {
        return radius * 2;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    /** This function draws the bubble on the screen */
    public void draw() {
        s.stroke(borderColor);
        s.fill(fillColor, 100);
        s.circle(x, y, radius * 2);
    }

    /**
     * This functions moves the bubble so that the next time the program runs the
     * bubble will have moved
     */
    public void move() {
        x = x + xSpeed;
        y = y + ySpeed;
        if (x > s.width - radius) {
            x = radius;
        } else if (x < radius) {
            x = s.width - radius;
        } else if (y > s.height - radius) {
            y = radius;
        } else if (y < radius) {
            y = s.height - radius;
        }
    }

}