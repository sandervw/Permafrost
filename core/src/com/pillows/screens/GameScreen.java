package com.pillows.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.pillows.gameworld.GameRenderer;
import com.pillows.gameworld.GameWorld;
import com.pillows.pfhelpers.InputHandler;

public class GameScreen implements Screen {

    private GameWorld world;
    private GameRenderer renderer;

    private float runTime = 0;

    public GameScreen() {

        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();
        float gameHeight = 204;
        float gameWidth = screenWidth / (screenHeight / gameHeight);
        float gameScale = gameHeight/screenHeight;

        int midPointX = (int) (gameWidth / 2);

        world = new GameWorld(midPointX, gameScale); // initialize world
        renderer = new GameRenderer(world, (int) gameWidth, midPointX); // initialize renderer

        //Set the inputprocessor for the screen
        Gdx.input.setInputProcessor(new InputHandler(world.getPenguin()));
    }

    //MAIN GAME LOOP
    @Override
    public void render(float delta) {
        runTime += delta;
        world.update(delta);
        renderer.render(runTime);
    }

    @Override
    public void resize(int width, int height) {
        Gdx.app.log("GameScreen", "resizing");
    }

    @Override
    public void show() {
        Gdx.app.log("GameScreen", "show called");
    }

    @Override
    public void hide() {
        Gdx.app.log("GameScreen", "hide called");
    }

    @Override
    public void pause() {
        Gdx.app.log("GameScreen", "pause called");
    }

    @Override
    public void resume() {
        Gdx.app.log("GameScreen", "resume called");
    }

    @Override
    public void dispose() {
        // Leave blank
    }

}
