package com.pillows.permafrost;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.pillows.screens.GameScreen;
import com.pillows.pfhelpers.AssetLoader;

public class PermafrostGame extends Game {

	@Override
	public void create() {
		Gdx.app.log("PermafrostGame", "created");
		AssetLoader.load();
		setScreen(new GameScreen());
	}

	@Override
	public void dispose() {
		super.dispose();
		AssetLoader.dispose();
	}

}
