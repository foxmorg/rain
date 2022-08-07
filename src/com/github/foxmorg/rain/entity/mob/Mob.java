package com.github.foxmorg.rain.entity.mob;

import com.github.foxmorg.rain.entity.Entity;
import com.github.foxmorg.rain.graphics.Sprite;

public abstract class Mob extends Entity {

    protected Sprite sprite;
    protected int dir = 0; // possible directions: 0 - north, 1 - east, 2 - south, 3 - west
    protected boolean moving = false;

    public void move() {

    }

    public void update() {

    }

    private boolean collision() {
        return false;
    }

}
