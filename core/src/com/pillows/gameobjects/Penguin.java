package com.pillows.gameobjects;

import com.badlogic.gdx.math.Vector2;

public class Penguin {

    private Vector2 position;
    private Vector2 velocity;
    private Vector2 acceleration;

    private float rotation; // For handling bird rotation
    private int width;
    private int height;

    private float gameScale;

    public Penguin(float x, float y, int width, int height, float gameScale) {
        this.width = width;
        this.height = height;
        this.gameScale = gameScale;
        position = new Vector2(x-10, y);
        velocity = new Vector2(0, 0);
        acceleration = new Vector2(0, 0);
    }

    public void update(float delta) {

        velocity.add(acceleration.cpy().scl(delta));

        if ((velocity.x < 0 && acceleration.x < 0) || (velocity.x > 0 && acceleration.x > 0)) {
            acceleration.x = 0;
            velocity.x = 0;
        }

        position.add(velocity.cpy().scl(delta));

    }

    public void onClick(int screenX) {

        float hitPos = screenX*gameScale;

        //If left side of screen is tapped, move left
        if(hitPos < position.x+(width/2)){
            velocity.x = -140;
            acceleration.x = 360;
        }
        //Else if the right side of the screen is tapped move right
        else if(hitPos > position.x+(width/2)){
            velocity.x = 140;
            acceleration.x = -360;
        }

    }

    public float getX() {
        return position.x;
    }

    public float getY() {
        return position.y;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public float getRotation() {
        return rotation;
    }

}
