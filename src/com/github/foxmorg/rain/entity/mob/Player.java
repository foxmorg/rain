package com.github.foxmorg.rain.entity.mob;

import com.github.foxmorg.rain.graphics.Screen;
import com.github.foxmorg.rain.graphics.Sprite;
import com.github.foxmorg.rain.input.Keyboard;

public class Player extends Mob {

    private Keyboard input;
    private Sprite sprite;

    public Player(Keyboard input) {
        this.input = input;
        sprite = Sprite.playerForward;
    }

    public Player(int x, int y, Keyboard input) {
        this.x = x;
        this.y = y;
        this.input = input;
    }

    @Override
    public void update() {
        int xa = 0, ya = 0;
        if (input.up) ya--;
        if (input.down) ya++;
        if (input.left) xa--;
        if (input.right) xa++;

        if (xa != 0 || ya != 0) move(xa, ya);
    }

    @Override
    public void render(Screen screen) {
        int flip = 0;
        if (dir == 0) sprite = Sprite.playerForward;
        if (dir == 1) sprite = Sprite.playerSide;
        if (dir == 2) sprite = Sprite.playerBack;
        if (dir == 3) {
            sprite = Sprite.playerSide;
            flip = 1;
        }
        screen.renderPlayer(x - 16, y - 16, sprite, flip);
    }

}
