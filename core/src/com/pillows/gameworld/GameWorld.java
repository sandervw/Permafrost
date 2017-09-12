package com.pillows.gameworld;

import com.pillows.gameobjects.Penguin;
import com.pillows.gameobjects.ScrollHandler;

public class GameWorld {

    private Penguin penguin;
    private ScrollHandler scroller;

    public GameWorld(int midPointX, float gameScale) {
        penguin = new Penguin(midPointX, 49, 12, 19, gameScale);
        scroller = new ScrollHandler(midPointX + 66);
    }

    public void update(float delta) {
        penguin.update(delta);
        scroller.update(delta);
    }

    public Penguin getPenguin() {
        return penguin;
    }

    public ScrollHandler getScroller() {
        return scroller;
    }
}
