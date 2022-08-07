package com.github.foxmorg.rain.level.tile;

import com.github.foxmorg.rain.graphics.Screen;
import com.github.foxmorg.rain.graphics.Sprite;

public class GrassTile extends Tile {

    public GrassTile(Sprite sprite) {
        super(sprite);
    }

    @Override
    public void render(int x, int y, Screen screen) {
        screen.renderTile(x << 4, y << 4, this);
    }
}
