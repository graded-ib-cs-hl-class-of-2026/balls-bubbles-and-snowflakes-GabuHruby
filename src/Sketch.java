import processing.core.PApplet;

public class Sketch extends PApplet {

    /** Represents one ball */
    private Ball ball1;
    private Ball ball2;
    private Ball ball3;
    private Ball ball4;
    private Ball[] balls;

    private Bubble bubble1;
    private Bubble bubble2;
    private Bubble bubble3;
    private Bubble bubble4;
    private Bubble[] bubbles;

    private Snowflake snowflake1;
    private Snowflake snowflake2;
    private Snowflake snowflake3;
    private Snowflake snowflake4;

    /**
     * This method can only be used to change the window size. It runs before the
     * window is created.
     */
    public void settings() {
        size(500, 500);
    }

    /**
     * Runs once at the beginning of the program, after the window is created. Use
     * this to initialize the sketch.
     */
    public void setup() {
        ball1 = new Ball(this);

        ball2 = new Ball(this, 13, 200, 200, 4, 2);
        ball2.setColors(color(0, 150, 0), color(0, 0, 0));

        ball3 = new Ball(this, 29, 300, 300, 1, 4);
        ball3.setColors(color(150, 0, 0), color(0, 0, 0));

        ball4 = new Ball(this, 32, 400, 400, 5, 2);
        ball4.setColors(color(0, 0, 150), color(0, 0, 0));
        balls = new Ball[] { ball1, ball2, ball3, ball4 };

        bubble1 = new Bubble(this, 25, 400, 400, 1, -4);
        bubble2 = new Bubble(this, 15, 100, 100, -1, -2);
        bubble3 = new Bubble(this, 35, 300, 300, 2, -1);
        bubble4 = new Bubble(this, 30, 200, 200, -1, -2);
        bubbles = new Bubble[] { bubble1, bubble2, bubble3, bubble4 };

        snowflake1 = new Snowflake(this, 10, 250, 250, 1, 2);
        snowflake2 = new Snowflake(this, 15, 100, 500, -2, 2);
        snowflake3 = new Snowflake(this, 20, 400, 100, 2, 3);
        snowflake4 = new Snowflake(this, 25, 300, 400, -1, 1);
    }

    /**
     * This method runs over and over and over, approximately 60 times per second!
     * By moving objects a tiny bit each frame, you can get the appearance of
     * movement.
     */
    public void draw() {
        background(150, 150, 255);
        ball1.draw();
        ball1.move();
        ball2.draw();
        ball2.move();
        ball3.draw();
        ball3.move();
        ball4.draw();
        ball4.move();

        bubble1.draw();
        bubble1.move();
        bubble2.draw();
        bubble2.move();
        bubble3.draw();
        bubble3.move();
        bubble4.draw();
        bubble4.move();

        snowflake1.draw();
        snowflake1.move();
        snowflake2.draw();
        snowflake2.move();
        snowflake3.draw();
        snowflake3.move();
        snowflake4.draw();
        snowflake4.move();

        for (int i = 0; i < balls.length; i++) {
            for (int k = i + 1; k < balls.length; k++) {
                if (balls[i].checkCollision(balls[k])) {
                    balls[i].collided();
                    balls[k].collided();
                }
            }
        }

        for (int i = 0; i < balls.length; i++) {
            for (int k = 0; k < bubbles.length; k++) {
                if (balls[i].checkCollision(bubbles[k])) {
                    bubbles[k].collided();
                }
            }
        }
    }

    /**
     * This method is called whenever the mouse is pressed. It checks if the mouse
     * is pressed on a ball, and if it is, the ball changes colors. If you press a
     * bubble, the bubble pops
     */
    public void mousePressed() {
        for (int i = 0; i < balls.length; i++) {
            if (balls[i].checkPressed(mouseX, mouseY)) {
                balls[i].setColors(color(random(0, 257), random(0, 257), random(0, 257)), color(0, 0, 0));
            }
        }
        for (int i = 0; i < bubbles.length; i++) {
            if (bubbles[i].checkPressed(mouseX, mouseY)) {
                bubbles[i].collided();
            }
        }
    }

    /** This method is called if a key is pressed */
    public void keyPressed() {
        // if space is pressed run this
        if (key == ' ') {
            // randomize everything on the screen
            // balls
            for (int i = 0; i < balls.length; i++) {
                // change colors
                balls[i].setColors(color(random(0, 257), random(0, 257), random(0, 257)), color(0, 0, 0));
                // change speeds
                balls[i].setSpeed(random(-4, 4), random(-4, 4));
                // change positions
                balls[i].setPosition(random(0 + balls[i].getRadius(), width - balls[i].getRadius()),
                        random(0 + balls[i].getRadius(), height - balls[i].getRadius()));
            }
        }
    }

    /**
     * All processing sketches have to use this main method. Don't touch this!
     */
    public static void main(String[] args) {
        PApplet.main("Sketch");
    }
}
