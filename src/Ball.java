class Ball {

    /*
     * In Processing, the Sketch works a lot like the World in the turtles. You
     * can't
     * draw a ball without knowing which sketch to draw it on, so you always need to
     * specify the sketch for a Ball object.
     */

    /** The sketch that the ball is inside */
    private Sketch s;
    /** the radius of the ball */
    private float radius;
    private float x;
    private float y;
    /** The number of pixels the ball moves right per frame */
    private float xSpeed;
    /** The number of pixels the ball moves down per frame */
    private float ySpeed;
    /** The color of the inside of the ball */
    private int fillColor;
    /** The color of the outside of the ball */
    private int borderColor;

    /** Empty constructor to keep the defaults. Only sets up our link. */
    public Ball(Sketch sketch) {
        s = sketch;
        radius = 20;
        x = 100;
        y = 100;
        xSpeed = 2;
        ySpeed = -1;
        fillColor = s.color(255, 100, 100);
        borderColor = s.color(0, 0, 0);
    }

    /** Fully specified constructor to allow changes to size, position, speed */
    /** Does NOT allow changing color! Need to use setColors() for that. */
    public Ball(Sketch sketch, float radius, float x, float y, float xspeed, float yspeed) {
        this.s = sketch;
        this.radius = radius;
        this.x = x;
        this.y = y;
        this.xSpeed = xspeed;
        this.ySpeed = yspeed;
    }

    // Accessors (getters) go here

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

    // Setters that you need go here - by default, only colors

    /** set the color of the ball */
    public void setColors(int fill, int border) {
        borderColor = border;
        fillColor = fill;
    }

    /** Change the speed of the ball */
    public void setSpeed(float x, float y) {
        xSpeed = x;
        ySpeed = y;
    }

    /** Change postition */
    public void setPosition(float xPos, float yPos) {
        x = xPos;
        y = yPos;
    }

    /** This function will check if the ball collides with another ball */
    public Boolean checkCollision(Ball b) {
        float bothRadii = radius + b.getRadius();

        float dx = x - b.getX();
        float dy = y - b.getY();

        float distance = (float) Math.sqrt((dx * dx) + (dy * dy));

        return (distance < bothRadii);
    }

    /** This function will check if the ball has been clicked */
    public Boolean checkPressed(float mouseX, float mouseY) {

        float dx = x - mouseX;
        float dy = y - mouseY;

        float distance = (float) Math.sqrt((dx * dx) + (dy * dy));

        return (distance < radius);
    }

    /** This function will check if the ball collides with another bubble */
    public Boolean checkCollision(Bubble b) {
        float bothRadii = radius + b.getRadius();

        float dx = x - b.getX();
        float dy = y - b.getY();

        float distance = (float) Math.sqrt((dx * dx) + (dy * dy));

        return (distance < bothRadii);
    }

    /**
     * This function will makes the ball "bounce" when it collides by reversing the
     * x and y spedd
     */
    public void collided() {
        xSpeed = -xSpeed;
        ySpeed = -ySpeed;
    }

    /**
     * Draws the ball on the given sketch
     */
    public void draw() {
        s.stroke(borderColor);
        s.fill(fillColor);
        // x and y are midpoint
        s.circle(x, y, radius * 2);
    }

    /**
     * Moves the ball so that the next time it draws it will be in a different place
     */
    public void move() {
        x = x + xSpeed;
        y = y + ySpeed;
        if (x > s.width - radius || x < radius) {
            xSpeed = -xSpeed;
        }
        if (y > s.height - radius || y < radius) {
            ySpeed = -ySpeed;
        }
    }

}