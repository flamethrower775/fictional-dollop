package com.mygdx.game.entity;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.world.GameMap;

public class Player extends Entity {
    public static final int SPEED = 50;

    Texture image;

    public Player(float x, float y,
                  GameMap map) {
        super(x, y, EntityType.PLAYER, map);
        image = new Texture("player.png");

    }

    public void update(float deltaTime) {
        super.update(deltaTime);
    }

    @Override
    public void render(OrthographicCamera cam, SpriteBatch batch) {
        batch.draw(image,
                pos.x,
                pos.y,
                getWidth(),
                getHeight());
    }
}
