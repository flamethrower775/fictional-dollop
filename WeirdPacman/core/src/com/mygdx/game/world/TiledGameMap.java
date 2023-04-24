package com.mygdx.game.world;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.*;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;


public class TiledGameMap extends GameMap{

    static TiledMap tileMap;
    OrthogonalTiledMapRenderer tiledMapRenderer;
    int mapWidth, mapHeight, tilePixelWidth, tilePixelHeight, mapPixelWidth, mapPixelHeight;

    public TiledGameMap() {
        tileMap = new TmxMapLoader().load("lastmap2.tmx");
        tiledMapRenderer = new OrthogonalTiledMapRenderer(tileMap);
        MapProperties prop = tileMap.getProperties();

        mapWidth = prop.get("width", Integer.class);
        mapHeight = prop.get("height", Integer.class);
        tilePixelWidth = prop.get("tilewidth", Integer.class);
        tilePixelHeight = prop.get("tileheight", Integer.class);

        mapPixelWidth = mapWidth * tilePixelWidth;
        mapPixelHeight = mapHeight * tilePixelHeight;

    }

    @Override
    public void render(OrthographicCamera camera, SpriteBatch batch) {

        tiledMapRenderer.setView(camera);
        tiledMapRenderer.render();

        batch.setProjectionMatrix(camera.combined);
        batch.begin();

        super.entities.get(0).render(camera, batch);
        super.render(camera, batch);
        batch.end();
    }




    @Override
    public void update(float delta) {
        super.update(delta);
    }

    @Override
    public void dispose() {
        tileMap.dispose();
    }

    @Override
    public TileType getTileTypeByCoords(int layer, int col, int row) {
        TiledMapTileLayer.Cell cell = ((TiledMapTileLayer)tileMap.getLayers().get(layer)).getCell(col, row);

        if (cell != null) {
            TiledMapTile tile = cell.getTile();
            if (tile != null) {
                int id = tile.getId();
                return TileType.getTileTypeById(id);
            }
        }
        return null;
    }

    public static int getTileIdByCoords(int layer, int col, int row) {
        TiledMapTileLayer.Cell cell = ((TiledMapTileLayer)tileMap.getLayers().get(layer)).getCell(col, row);

        if (cell != null) {
            TiledMapTile tile = cell.getTile();
            if (tile != null) {
                return tile.getId();
            }
        }
        return -1;
    }

    @Override
    public int getWidth() {
        return mapPixelWidth;
    }

    @Override
    public int getHeight() {
        return mapPixelHeight;
    }

    @Override
    public int getLayers() {
        return tileMap.getLayers().getCount();
    }
}