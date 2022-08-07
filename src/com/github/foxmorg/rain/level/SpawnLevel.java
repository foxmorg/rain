package com.github.foxmorg.rain.level;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SpawnLevel extends Level {

    public SpawnLevel(String path) {
        super(path);
    }

    @Override
    protected void loadLevel(String path) {
        try {
            BufferedImage image = ImageIO.read(SpawnLevel.class.getResource(path));
            int w = image.getWidth();
            int h = image.getHeight();
            tiles = new int[w * h];
            image.getRGB(0, 0, w, h, tiles, 0, w);
        } catch(IOException e) {
            e.printStackTrace();
            System.out.println("Exception! Could not load level file!");
        } finally {
            // NOP
        }
    }

    @Override
    protected void generateLevel() {
        System.out.println("Tiles: " + tiles[0]);
    }

}
