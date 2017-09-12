package com.pillows.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.pillows.gameobjects.Penguin;
import com.pillows.gameobjects.Rock;
import com.pillows.gameobjects.ScrollHandler;
import com.pillows.gameobjects.Side;
import com.pillows.pfhelpers.AssetLoader;

public class GameRenderer {

    //Need reference to world to know what to render
    private GameWorld myWorld;

    //setup orthographic camera for 2D view
    private OrthographicCamera cam;

    private ShapeRenderer shapeRenderer;

    private SpriteBatch batcher;

    // Game Objects
    private Penguin penguin;
    private ScrollHandler scroller;
    private Side frontSide, backSide, backSide2;
    private Rock rock1, rock2, rock3;

    private Animation penguinAnimation;
    private TextureRegion bg, sides, penguinTexture, rock;

    private int midPointX;
    private int gameWidth;

    public GameRenderer(GameWorld world, int gameWidth, int midPointX) {
        myWorld = world;

        // The word "this" refers to this instance.
        // We are setting the instance variables' values to be that of the
        // parameters passed in from GameScreen.
        this.gameWidth = gameWidth;
        this.midPointX = midPointX;

        cam = new OrthographicCamera();
        cam.setToOrtho(true, 136, 204);

        batcher = new SpriteBatch();
        // Attach batcher to camera
        batcher.setProjectionMatrix(cam.combined);

        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(cam.combined);

        // Call helper methods to initialize instance variables
        initGameObjects();
        initAssets();
    }

    public void render(float runTime) {


        // Fill the entire screen with black, to prevent potential flickering.
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);



        // Begin SpriteBatch
        batcher.begin();
        // Disable transparency
        // This is good for performance when drawing images that do not require
        // transparency.
        batcher.disableBlending();
        batcher.draw(bg, 0, 0, 136, 204);

        //draw sides
        drawSide();

        // The bird and rocks need transparency, so we enable that again.
        batcher.enableBlending();


        drawRocks();


        // Draw penguin at its coordinates
        // Pass in the runTime variable to get the current frame.
        batcher.draw(penguinTexture, penguin.getX(), penguin.getY(), penguin.getWidth(), penguin.getHeight());

        // End SpriteBatch
        batcher.end();


    }

    private void initGameObjects() {
        penguin = myWorld.getPenguin();
        scroller = myWorld.getScroller();
        frontSide = scroller.getFrontSide();
        backSide = scroller.getBackSide();
        backSide2 = scroller.getBackSide2();
        rock1 = scroller.getRock1();
        rock2 = scroller.getRock2();
        rock3 = scroller.getRock3();
    }

    private void initAssets() {
        bg = AssetLoader.bg;
        sides = AssetLoader.sides;
        rock = AssetLoader.rock;
        penguinTexture = AssetLoader.penguin;
    }

    private void drawSide() {
        // Draw the Side
        batcher.draw(sides, frontSide.getX(), frontSide.getY(),
                frontSide.getWidth(), frontSide.getHeight());
        batcher.draw(sides, backSide.getX(), backSide.getY(),
                backSide.getWidth(), backSide.getHeight());
        batcher.draw(sides, backSide2.getX(), backSide2.getY(),
                backSide2.getWidth(), backSide2.getHeight());
    }

    private void drawRocks(){
        batcher.draw(rock, rock1.getX() + rock1.getWidth() - 14, rock1.getY() - 1, 37, 27);
        batcher.draw(rock, rock1.getX() + rock1.getWidth() + 45, rock1.getY() -1 , 37, 27);

        batcher.draw(rock, rock2.getX() + rock2.getWidth() - 14, rock2.getY() - 1, 37, 27);
        batcher.draw(rock, rock2.getX() + rock2.getWidth() + 45, rock2.getY() -1 , 37, 27);

        batcher.draw(rock, rock3.getX() + rock3.getWidth() - 14, rock3.getY() - 1, 37, 27);
        batcher.draw(rock, rock3.getX() + rock3.getWidth() + 45, rock3.getY() -1 , 37, 27);
    }

}
