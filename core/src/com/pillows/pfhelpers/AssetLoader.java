package com.pillows.pfhelpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.Animation;

public class AssetLoader {

    public static Texture texture;
    public static TextureRegion bg, sides, penguin, rock;

    public static Animation penguinAnimation; //used later
    //public static TextureRegion penguin, penguinDown, penguinUp; // used later

    public static void load() {

        texture = new Texture(Gdx.files.internal("data/texture.png"));
        texture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

        bg = new TextureRegion(texture, 0, 0, 127, 127);
        bg.flip(false, true);

        sides = new TextureRegion(texture, 1, 128, 8, 132);
        sides.flip(false, true);

        penguin = new TextureRegion(texture, 129, 29, 34, 53);
        penguin.flip(false, true);

        rock = new TextureRegion(texture, 128, 0, 37, 27);
        rock.flip(false, true);



        //TextureRegion[] birds = {birdDown, bird, birdUp};
        //birdAnimation = new Animation(0.06f, birds);
        //birdAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);

    }

    public static void dispose() {
        // We must dispose of the texture when we are finished.
        texture.dispose();

    }

}
