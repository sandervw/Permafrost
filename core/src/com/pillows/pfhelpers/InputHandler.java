package com.pillows.pfhelpers;

import com.badlogic.gdx.InputProcessor;
import com.pillows.gameobjects.Penguin;

public class InputHandler implements InputProcessor {

    private Penguin myPenguin;

    public InputHandler(Penguin penguin) {
        myPenguin = penguin;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        myPenguin.onClick(screenX);
        return true;
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

}