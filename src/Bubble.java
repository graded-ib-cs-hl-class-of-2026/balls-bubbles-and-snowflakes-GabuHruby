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

    /** Change the speed of the bubble */
    public void setSpeed(float x, float y) {
        xSpeed = x;
        ySpeed = y;
    }

    /** Change postition of the snowflake */
    public void setPosition(float xPos, float yPos) {
        x = xPos;
        y = yPos;
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

    /** This runs if the bubble collidees with a ball */
    public void collided() {
        float decideCase = s.random(1, 3);
        // Decides if bubble will come out from side or from top
        // 1 will come out from either side and random y
        // 2 will come out from top or bottom and ranodm x
        if ((int) decideCase == 1) {
            decideCase = s.random(1, 3);
            // spawn on left
            if (decideCase == 1) {
                x = 0;
                xSpeed = s.random(1, 4);
            }
            // spawn on right
            else {
                x = s.width - radius;
                xSpeed = s.random(-4, -1);
            }
            y = s.random(50, s.width - 50);
            ySpeed = s.random(-4, 4);
        } else {
            decideCase = s.random(1, 3);
            // spawn on top
            if (decideCase == 1) {
                y = 0;
                ySpeed = s.random(1, 4);
            }
            // spawn on bottom
            else {
                y = s.width - radius;
                ySpeed = s.random(-4, -1);
            }
            x = s.random(50, s.width - 50);
            xSpeed = s.random(-4, 4);
        }
    }

    /** This function will check if the bubble has been clicked */
    public Boolean checkPressed(float mouseX, float mouseY) {

        float dx = x - mouseX;
        float dy = y - mouseY;

        float distance = (float) Math.sqrt((dx * dx) + (dy * dy));

        return (distance < radius);
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