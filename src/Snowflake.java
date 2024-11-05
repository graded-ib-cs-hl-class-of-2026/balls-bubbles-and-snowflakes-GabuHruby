class Snowflake {

    /*
     * this class will represent a Snowflake that moves around the screen and pops
     * when
     * it reaches a side
     */

    /** The sketch that the Snowflake is inside of */
    private Sketch s;
    /** the radius of the snowflake */
    private float radius;
    private float x;
    private float y;
    /** The number of pixels the Snowflake moves right per frame */
    private float xSpeed;
    /** The number of pixels the Snowflake moves down per frame */
    private float ySpeed;

    /**
     * Fully specified constructor to allow changes to size, position, speed of the
     * Snowflake
     */
    public Snowflake(Sketch sketch, float radius, float x, float y, float xspeed, float yspeed) {
        this.s = sketch;
        this.radius = radius;
        this.x = x;
        this.y = y;
        this.xSpeed = xspeed;
        this.ySpeed = yspeed;
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

    /** Change the speed of the snowflake */
    public void setSpeed(float x, float y) {
        xSpeed = x;
        ySpeed = y;
    }

    /** Change postition of the snowflake */
    public void setPosition(float xPos, float yPos) {
        x = xPos;
        y = yPos;
    }

    /** This function draws the snowflake on the screen */
    public void draw() {
        s.line(x + radius, y, x - radius, y);
        s.line(x, y + radius, x, y - radius);
        s.line(x + radius * .707f, y + radius * .707f, x - radius * .707f, y - radius * .707f);
        s.line(x + radius * .707f, y - radius * .707f, x - radius * .707f, y + radius * .707f);
    }

    /**
     * This functions moves the snowflake so that the next time the program runs the
     * it will have moved
     */
    public void move() {
        x = x + xSpeed / 2;
        y = y + ySpeed;
        if (x > s.width + radius) {
            x = 0 - radius;
        } else if (x < 0 - radius) {
            x = s.width + radius;
        } else if (y > s.height + radius) {
            y = 0;
        }
    }
}