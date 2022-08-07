package com.github.foxmorg.rain.level;

import com.github.foxmorg.rain.level.tile.Tile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SpawnLevel extends Level {

    private Tile[] tiles;
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
            image.getRGB(0, 0, w, h, levelPixels, 0, w);
        } catch(IOException e) {
            e.printStackTrace();
            System.out.println("Exception! Could not load level file!");
        } finally {
            // NOP
        }
    }

    @Override
    protected void generateLevel() {

    }

}
