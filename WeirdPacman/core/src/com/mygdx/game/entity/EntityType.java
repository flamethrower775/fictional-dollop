package com.mygdx.game.entity;

import javax.swing.text.html.parser.Entity;

public enum EntityType {
    PLAYER("player", 20, 20),
    RUNNER("runner", 25, 25),

    STRENGTH_POTION("strength", 10, 10);


    private String id;
    private int width, height;

    private EntityType(String id, int width, int height) {
        this.id = id;
        this.width = width;
        this.height = height;
    }

    public String getId() {
        return id;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
