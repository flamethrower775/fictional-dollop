package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.world.GameMap;
import com.mygdx.game.world.TiledGameMap;

public class BetterPacmanGame extends ApplicationAdapter {
	OrthographicCamera cam;
	SpriteBatch batch;
	GameMap gameMap;

	@Override
	public void create () {
		batch = new SpriteBatch();
		cam = new OrthographicCamera();

		cam.setToOrtho(false, Gdx.graphics.getWidth(),
				Gdx.graphics.getHeight());
		cam.update();
		gameMap = new TiledGameMap();
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);


		cam.update();
		gameMap.update(Gdx.graphics.getDeltaTime());
		gameMap.render(cam, batch);

		batch.begin();
		batch.end();

	}

	@Override
	public void dispose () {
		batch.dispose();
		gameMap.dispose();
	}
}
