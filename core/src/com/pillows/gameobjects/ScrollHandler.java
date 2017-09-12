package com.pillows.gameobjects;

public class ScrollHandler {

    // ScrollHandler will create all five objects that we need.
    private Side frontSide, backSide, backSide2;
    private Rock rock1, rock2, rock3;

    // ScrollHandler will use the constants below to determine
    // how fast we need to scroll and also determine
    // the size of the gap between each of the rocks.

    // Capital letters are used by convention when naming constants.
    public static final int SCROLL_SPEED = -59;
    public static final int ROCK_GAP = 60;

    // Constructor receives a float that tells us where we need to create our
    // sides and rock objects.
    public ScrollHandler(float yPos) {

        frontSide = new Side(0, yPos, 4, 132, SCROLL_SPEED);
        backSide = new Side(0, frontSide.getTailY(), 4, 132, SCROLL_SPEED);
        backSide2 = new Side(0, backSide.getTailY(), 4, 132, SCROLL_SPEED);

        rock1 = new Rock(0, 300, 37, 27, SCROLL_SPEED);
        rock2 = new Rock(0, rock1.getTailY() + ROCK_GAP, 37, 27, SCROLL_SPEED);
        rock3 = new Rock(0, rock2.getTailY() + ROCK_GAP, 37, 27, SCROLL_SPEED);

    }

    public void update(float delta) {

        // Update our objects
        frontSide.update(delta);
        backSide.update(delta);
        backSide2.update(delta);
        rock1.update(delta);
        rock2.update(delta);
        rock3.update(delta);

        // Check if any of the rocks are scrolled left,
        // and reset accordingly
        if (rock1.isScrolledTop()) {
            rock1.reset(rock3.getTailY() + ROCK_GAP);
        } else if (rock2.isScrolledTop()) {
            rock2.reset(rock1.getTailY() + ROCK_GAP);
        } else if (rock3.isScrolledTop()) {
            rock3.reset(rock2.getTailY() + ROCK_GAP);
        }

        // Same with Side
        if (frontSide.isScrolledTop()) {
            frontSide.reset(backSide2.getTailY());

        } else if (backSide.isScrolledTop()) {
            backSide.reset(frontSide.getTailY());

        } else if (backSide2.isScrolledTop()) {
            backSide2.reset(backSide.getTailY());

        }

    }

    // The getters for our five instance variables
    public Side getFrontSide() {
        return frontSide;
    }

    public Side getBackSide() {
        return backSide;
    }

    public Side getBackSide2() {
        return backSide2;
    }

    public Rock getRock1() {
        return rock1;
    }

    public Rock getRock2() {
        return rock2;
    }

    public Rock getRock3() {
        return rock3;
    }

}