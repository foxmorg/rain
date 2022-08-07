package com.github.foxmorg.rain.entity.mob;

import com.github.foxmorg.rain.graphics.Screen;
import com.github.foxmorg.rain.graphics.Sprite;
import com.github.foxmorg.rain.input.Keyboard;

public class Player extends Mob {

    private Keyboard input;
    private Sprite sprite;
    private int anim = 0;
    private boolean walking = false;

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
        if (anim < 7500) {
            anim++;
        } else {
            anim = 0;
        }
        if (input.up) ya--;
        if (input.down) ya++;
        if (input.left) xa--;
        if (input.right) xa++;

        if (xa != 0 || ya != 0) {
            move(xa, ya);
            walking = true;
        } else {
            walking = false;
        }
    }

    @Override
    public void render(Screen screen) {
        int flip = 0;
        if (dir == 0) {
            sprite = Sprite.playerForward;
            if (walking) {
                if (anim % 20 > 10) {
                    sprite = Sprite.playerForward1;
                } else {
                    sprite = Sprite.playerForward2;
                }
            }
        }
        if (dir == 1) {
            sprite = Sprite.playerSide;
            if (walking) {
                if (anim % 20 > 10) {
                    sprite = Sprite.playerSide1;
                } else {
                    sprite = Sprite.playerSide2;
                }
            }
        }
        if (dir == 2) {
            sprite = Sprite.playerBack;
            if (walking) {
                if (anim % 20 > 10) {
                    sprite = Sprite.playerBack1;
                } else {
                    sprite = Sprite.playerBack2;
                }
            }
        }
        if (dir == 3) {
            sprite = Sprite.playerSide;
            if (walking) {
                if (anim % 20 > 10) {
                    sprite = Sprite.playerSide1;
                } else {
                    sprite = Sprite.playerSide2;
                }
            }
            flip = 1;
        }
        screen.renderPlayer(x - 16, y - 16, sprite, flip);
    }

}
