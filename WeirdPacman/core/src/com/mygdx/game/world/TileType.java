package com.mygdx.game.world;

// set of static objects

import com.badlogic.gdx.maps.tiled.TiledMap;

import java.util.HashMap;

public enum TileType {

    GRASS(556, false, "grass"),
    ROAD(547, true, "road"),
    ROAD2(806, true, "road2");

    public static final int TILE_SIZE = 16;

    private int id;
    private boolean walkable;
    private String name;
    private float damage;

    private TileType(int id, boolean walkable, String name) {
        this(id, walkable, name, 0);
    }

    private TileType(int id, boolean walkable, String name, float damage) {
        this.id = id;
        this.walkable = walkable;
        this.name = name;
        this.damage = damage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isWalkable() {
        return walkable;
    }

    public String getName() {
        return name;
    }

    public float getDamage() {
        return damage;
    }

    private static HashMap<Integer, TileType> tileMap;

    static {
        tileMap = new HashMap<Integer, TileType>();
        for (TileType tileType : TileType.values()) {
            tileMap.put(tileType.getId(), tileType);
        }
    }

    public static TileType getTileTypeById (int id) {
        return tileMap.get(id);
    }
}
