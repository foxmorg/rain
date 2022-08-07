package com.github.foxmorg.rain.entity.mob;

import com.github.foxmorg.rain.input.Keyboard;

public class Player extends Mob {

    private Keyboard input;

    public Player(Keyboard input) {
        this.input = input;
    }

    public Player(int x, int y, Keyboard input) {
        this.x = x;
        this.y = y;
        this.input = input;
    }

    @Override
    public void update() {
        if (input.up) y--;
        if (input.down) y++;
        if (input.left) x--;
        if (input.right) x++;
    }

    @Override
    public void render() {

    }

}
