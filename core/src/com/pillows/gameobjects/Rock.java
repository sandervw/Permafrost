package com.pillows.gameobjects;

import java.util.Random;

public class Rock extends Scrollable {

    private Random r;

    // When Rock's constructor is invoked, invoke the super (Scrollable)
    // constructor
    public Rock(float x, float y, int width, int height, float scrollSpeed) {
        super(x, y, width, height, scrollSpeed);
        // Initialize a Random object for Random number generation
        r = new Random();
    }

    @Override
    public void reset(float newY) {
        // Call the reset method in the superclass (Scrollable)
        super.reset(newY);
        // Change the width to a random number
        width = r.nextInt(90) + 15;
    }

}