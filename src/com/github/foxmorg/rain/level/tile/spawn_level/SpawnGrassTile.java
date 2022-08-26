package com.github.foxmorg.rain.level.tile.spawn_level;

import com.github.foxmorg.rain.graphics.Screen;
import com.github.foxmorg.rain.graphics.Sprite;
import com.github.foxmorg.rain.level.tile.Tile;

public class SpawnGrassTile extends Tile {
    public SpawnGrassTile(Sprite sprite) {
        super(sprite);
    }

    @Override
    public void render(int x, int y, Screen screen) {
        screen.renderTile(x << 4, y << 4, this);
    }
}
