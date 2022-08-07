package com.github.foxmorg.rain.level;

import com.github.foxmorg.rain.level.tile.Tile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SpawnLevel extends Level {

    private int[] levelPixels;

    public SpawnLevel(String path) {
        super(path);
    }

    @Override
    protected void loadLevel(String path) {
        try {
            BufferedImage image = ImageIO.read(SpawnLevel.class.getResource(path));
            int w = image.getWidth();
            int h = image.getHeight();
            tiles = new Tile[w * h];
            levelPixels = new int[w * h];
            image.getRGB(0, 0, w, h, levelPixels, 0, w);
        } catch(IOException e) {
            e.printStackTrace();
            System.out.println("Exception! Could not load level file!");
        } finally {
            // NOP
        }
    }

    // Grass = 0x00FF00
    // Flower = 0xFFFF00
    // Rock = 0x7F7F00
    @Override
    protected void generateLevel() {
        for (int i = 0; i < levelPixels.length; i++) {
            if (levelPixels[i] == 0xFF00FF00) tiles[i] = Tile.grass;
            if (levelPixels[i] == 0xFFFFFF00) tiles[i] = Tile.flower;
            if (levelPixels[i] == 0xFF7F7F00) tiles[i] = Tile.rock;
        }
    }

}
