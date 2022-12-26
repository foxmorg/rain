package com.github.foxmorg.rain.entity.mob;

import com.github.foxmorg.rain.entity.Entity;
import com.github.foxmorg.rain.graphics.Sprite;

public abstract class Mob extends Entity {

    protected Sprite sprite;
    protected int dir = 0; // possible directions: 0 - north, 1 - east, 2 - south, 3 - west
    protected boolean moving = false;

    public void move(int xa, int ya) {
        if (xa != 0 && ya != 0) {
            move(xa, 0);
            move(0, ya);
            return;
        }

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
        boolean solid = false;
        for (int corner = 0; corner < 4; corner++) {
            int xt = ((x + xa) + corner % 2 * 14 - 8) / 16;
            int yt = ((y + ya) + corner / 2 * 12 + 3) / 16;
            if (level.getTile(xt, yt).solid()) solid = true;
        }
        return solid;
    }

    public void render() {

    }

}
