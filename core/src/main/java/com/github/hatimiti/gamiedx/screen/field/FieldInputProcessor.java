package com.github.hatimiti.gamiedx.screen.field;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Input;
import com.github.hatimiti.gamiedx.DefaultInputProcessor;

class FieldInputProcessor extends DefaultInputProcessor {

    private final FieldScreen screen;

    FieldInputProcessor(Game game, FieldScreen screen) {
        super(game);
        this.screen = screen;
    }

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode)
        {
            case Input.Keys.LEFT:
                screen.container.getPlayer().setLeftMove(true);
                break;
            case Input.Keys.RIGHT:
                screen.container.getPlayer().setRightMove(true);
                break;
            case Input.Keys.UP:
                screen.container.getPlayer().setUpMove(true);
                break;
            case Input.Keys.DOWN:
                screen.container.getPlayer().setDownMove(true);
                break;
        }
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        switch (keycode)
        {
            case Input.Keys.LEFT:
                screen.container.getPlayer().setLeftMove(false);
                break;
            case Input.Keys.RIGHT:
                screen.container.getPlayer().setRightMove(false);
                break;
            case Input.Keys.UP:
                screen.container.getPlayer().setUpMove(false);
                break;
            case Input.Keys.DOWN:
                screen.container.getPlayer().setDownMove(false);
                break;
        }
        return true;
    }

}
