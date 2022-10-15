package com.github.foxmorg.rain.entity.mob;

import com.github.foxmorg.rain.entity.Entity;
import com.github.foxmorg.rain.graphics.Sprite;

public abstract class Mob extends Entity {

    protected Sprite sprite;
    protected int dir = 0; // possible directions: 0 - north, 1 - east, 2 - south, 3 - west
    protected boolean moving = false;

    public void move(int xa, int ya) {
        if (xa > 0) dir = 1;
        if (xa < 0) dir = 3;
        if (ya > 0) dir = 2;
        if (ya < 0) dir = 0;

        if (!collision(xa, ya)) {
            x += xa;
            y += ya;
        }
    }

    public void update() {

    }

    private boolean collision(int xa, int ya) {
        return level.getTile((x + xa) / 16, (y + ya) / 16).solid();
    }

    public void render() {

    }

}
