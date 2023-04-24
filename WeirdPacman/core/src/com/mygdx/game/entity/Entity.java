package com.mygdx.game.entity;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.world.GameMap;
import java.awt.Rectangle;

public abstract class Entity {

    protected int x, y;
    protected Vector2 pos;
    protected EntityType type;
    protected float velocityY = 0;
    protected float velocityX = 0;
    protected int score = 0;

    protected GameMap map;
    protected boolean onRoad = false;

    public Entity(float x, float y, EntityType type,
                  GameMap map) {
        this.pos = new Vector2(x, y);
        this.type = type;
        this.map = map;
    }

    public void update (float deltaTime) {

    }

    public abstract void render (OrthographicCamera cam, SpriteBatch batch);
    protected void moveX(float amount) {
        float newX = pos.x + amount;
        if (map.doesRectCollideWithMap
                (newX, pos.y, getWidth(), getHeight())) {
            this.pos.x = newX;
        }

    }

    protected void moveY(float amount) {
        float newY = pos.y + amount;

        if (map.doesRectCollideWithMap
                (pos.x, newY, getWidth(), getHeight())) {

            this.pos.y = newY;
        }
    }

    public Vector2 getPos() {
        return pos;
    }

    public EntityType getType() {
        return type;
    }

    public float getX() {
        return pos.x;
    }

    public float getY() {
        return pos.y;
    }
    public void setX(float x) {
        this.pos.x = x;
    }

    public void setY(float y) {
        this.pos.y = y;
    }
    public int getScore() {
        return score;
    }



    public boolean onRoad() {
        return onRoad;
    }

    public int getHeight() {
        return type.getHeight();
    }
    public int getWidth() {
        return type.getWidth();
    }

    public Rectangle getBounds() {
        return new Rectangle((int)(Math.floor(pos.x)),
                (int)(Math.floor(pos.y)), getWidth(), getHeight());
    }

    public boolean isOnPotion() {
        return map.checkCollisions();
    }

    public boolean isDead() {
        return map.checkCollisionWithEnemy();
    }
}