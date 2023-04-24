package com.mygdx.game.world;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.entity.*;

import java.awt.*;
import java.util.ArrayList;

public abstract class GameMap {
    protected ArrayList<Entity> entities;
    protected ArrayList<Entity> enemies;
    protected ArrayList<Entity> potions;

    protected Vector2 enemyPos;
    protected Vector2 runnerPos;
    protected Vector2 direction;

    public GameMap() {

        entities = new ArrayList<Entity>();
        entities.add(new Runner(100, 70, this));
        entities.add(new Runner2(150, 70, this));

        enemies = new ArrayList<Entity>();
        enemies.add(new Player(346, 415, this));
        enemies.add(new Player(346, 415, this));

        potions = new ArrayList<Entity>();
        potions.add(new StrengthPotion(12.f, 84, this));
        potions.add(new StrengthPotion(83,  84, this));
        potions.add(new StrengthPotion(152, 84, this));

        potions.add(new StrengthPotion(177, 30, this));
        potions.add(new StrengthPotion(235, 30, this));
        potions.add(new StrengthPotion(291, 30, this));

        potions.add(new StrengthPotion(291, 60, this));
        potions.add(new StrengthPotion(291, 100, this));
        potions.add(new StrengthPotion(291, 150, this));

        potions.add(new StrengthPotion(126, 139, this));
        potions.add(new StrengthPotion(82, 215, this));
        potions.add(new StrengthPotion(127, 215, this));

        potions.add(new StrengthPotion(176, 215, this));
        potions.add(new StrengthPotion(225, 215, this));
        potions.add(new StrengthPotion(286, 215, this));

        potions.add(new StrengthPotion(346, 215, this));
        potions.add(new StrengthPotion(395, 215, this));
        potions.add(new StrengthPotion(404, 165, this));

        potions.add(new StrengthPotion(452, 152, this));
        potions.add(new StrengthPotion(400, 278, this));
        potions.add(new StrengthPotion(400, 250, this));

        potions.add(new StrengthPotion(82, 252, this));
        potions.add(new StrengthPotion(82, 280, this));
        potions.add(new StrengthPotion(82, 307, this));

        potions.add(new StrengthPotion(64, 310, this));
        potions.add(new StrengthPotion(28, 310, this));
        potions.add(new StrengthPotion(0.2f, 310, this));

        potions.add(new StrengthPotion(33, 347, this));
        potions.add(new StrengthPotion(33, 374, this));
        potions.add(new StrengthPotion(33, 404, this));

        potions.add(new StrengthPotion(42, 436, this));
        potions.add(new StrengthPotion(69, 456, this));
        potions.add(new StrengthPotion(123, 456, this));

        potions.add(new StrengthPotion(153, 436, this));
        potions.add(new StrengthPotion(196, 456, this));
        potions.add(new StrengthPotion(225, 456, this));

        potions.add(new StrengthPotion(158, 414, this));
        potions.add(new StrengthPotion(158, 389, this));
        potions.add(new StrengthPotion(172, 363, this));

        potions.add(new StrengthPotion(172, 350, this));
        potions.add(new StrengthPotion(200, 342, this));
        potions.add(new StrengthPotion(239, 342, this));

        potions.add(new StrengthPotion(273, 342, this));
        potions.add(new StrengthPotion(310, 342, this));
        potions.add(new StrengthPotion(347, 342, this));

        potions.add(new StrengthPotion(381, 342, this));
        potions.add(new StrengthPotion(413, 342, this));
        potions.add(new StrengthPotion(467, 360, this));

        potions.add(new StrengthPotion(467, 388, this));
        potions.add(new StrengthPotion(467, 415, this));
        potions.add(new StrengthPotion(467, 445, this));

    }

    BitmapFont font = new BitmapFont();

    public void render(OrthographicCamera camera, SpriteBatch batch) {
        font.draw(batch, "Better Pacman!", 515, 475);

        String lala = Integer.toString(entities.get(0).getScore());
        font.draw(batch, "Mani: ", 515, 430);

        String lala2 = Integer.toString(entities.get(1).getScore());
        font.draw(batch, "Gabe: ", 515, 400);

        font.draw(batch, lala, 580, 430);
        font.draw(batch, lala2, 580, 395);

        for (Entity entity : entities) {
            entity.render(camera, batch);
        }
        for (Entity entity : enemies) {
            entity.render(camera, batch);
        }
        for (Entity entity : potions) {
            entity.render(camera, batch);
        }


    }
    public void update (float delta) {
        for (Entity entity : entities) {
            entity.update(delta);
        }
        for (Entity entity : potions) {
            entity.update(delta);
        }

        enemyPos = new Vector2(enemies.get(0).getX(), enemies.get(0).getY());
        runnerPos = new Vector2(entities.get(0).getX(), entities.get(0).getY());

        direction = new Vector2();

        direction.x = (runnerPos.x + 10) - (enemyPos.x + 10);
        direction.y = (runnerPos.y + 10) - (enemyPos.y + 10);
        direction.nor();

        float lala1 = enemies.get(0).getX();
        enemies.get(0).setX(lala1 + direction.x * 0.5f);

        float lala2 = enemies.get(0).getY();
        enemies.get(0).setY(lala2 + direction.y * 0.5f);


        enemyPos = new Vector2(enemies.get(1).getX(), enemies.get(1).getY());
        runnerPos = new Vector2(entities.get(1).getX(), entities.get(1).getY());

        direction = new Vector2();

        direction.x = (runnerPos.x + 10) - (enemyPos.x + 10);
        direction.y = (runnerPos.y + 10) - (enemyPos.y + 10);
        direction.nor();

        float lala3 = enemies.get(1).getX();
        enemies.get(1).setX(lala3 + direction.x * 0.5f);

        float lala4 = enemies.get(1).getY();
        enemies.get(1).setY(lala4 + direction.y * 0.5f);

    }
    public abstract void dispose();


    // get tile by pixel position within the game world at a specified layer
    public TileType getTileTypeByLocation(int layer, float x, float y) {
        return this.getTileTypeByCoords(layer, (int) x / TileType.TILE_SIZE,
                (int) y / TileType.TILE_SIZE);
    }

    public abstract TileType getTileTypeByCoords(int layer, int col, int row);

    public boolean doesRectCollideWithMap(float x, float y, int width, int height) {
        if ( x < 0 || y < 0 || x + width >= getPixelWidth() || y + height >= getPixelHeight()) {
            return true;
        }

        for (int row = (int)Math.floor(y / TileType.TILE_SIZE) + 1; row < Math.ceil(((y + height) / TileType.TILE_SIZE) - 0.5f); row ++) {
            for (int col = (int)Math.floor(x / TileType.TILE_SIZE) + 1; col < Math.ceil(((x + width) / TileType.TILE_SIZE) - 0.5f); col ++) {
                int type = TiledGameMap.getTileIdByCoords(0, col, row);
                //System.out.println(type + " " + x + " " + y);
                if (type != -1) return true;
            }
        }
        return false;
    }

    public boolean checkCollisions() {
        if(potions.isEmpty()) {
            gameWin();
        }

        for (Entity player : entities) {
            Rectangle playerBox = player.getBounds();
            for (Entity potion : potions) {
                Rectangle potionBox = potion.getBounds();

                if (playerBox.intersects(potionBox)) {
                    potions.remove(potion);
                    return true;
                }
            }
        }
        return false;
    }


    public boolean checkCollisionWithEnemy() {
        for (Entity player : entities) {
            Rectangle playerBox = player.getBounds();
            //System.out.println(playerBox.x + " " + playerBox.y);
            for (Entity enemy : enemies) {
                Rectangle enemyBox = enemy.getBounds();

                if (playerBox.intersects(enemyBox)) {
                    //System.out.println("lala");
                    gameLose();
                    return true;
                }
            }
        }
        return false;
    }

    public void gameLose() {
        System.out.println("You Lose :(");
    }

    public void gameWin() {
        System.out.println("You Win!");
    }
    public int getPixelWidth() {
        return this.getWidth() + TileType.TILE_SIZE;
    }

    public int getPixelHeight() {
        return this.getHeight() + TileType.TILE_SIZE;
    }

    public abstract int getWidth();
    public abstract int getHeight();
    public abstract int getLayers();
}
