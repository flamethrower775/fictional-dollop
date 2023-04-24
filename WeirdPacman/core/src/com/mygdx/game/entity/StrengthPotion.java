package com.mygdx.game.entity;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.world.GameMap;

public class StrengthPotion extends Entity{
    Texture image;
    public static final int POINTS = 10;

    public StrengthPotion(float x, float y, GameMap map) {
        super(x, y, EntityType.STRENGTH_POTION, map);
        image = new Texture("potion_good.png");
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
