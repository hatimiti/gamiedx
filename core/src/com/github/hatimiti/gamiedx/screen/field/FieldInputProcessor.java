package com.github.hatimiti.gamiedx.screen.field;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Input;
import com.github.hatimiti.gamiedx.DefaultInputProcessor;

public class FieldInputProcessor extends DefaultInputProcessor {

    private final FieldScreen screen;

    public FieldInputProcessor(Game game, FieldScreen screen) {
        super(game);
        this.screen = screen;
    }

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode)
        {
            case Input.Keys.LEFT:
                screen.player.setLeftMove(true);
                break;
            case Input.Keys.RIGHT:
                screen.player.setRightMove(true);
                break;
            case Input.Keys.UP:
                screen.player.setUpMove(true);
                break;
            case Input.Keys.DOWN:
                screen.player.setDownMove(true);
                break;
        }
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        switch (keycode)
        {
            case Input.Keys.LEFT:
                screen.player.setLeftMove(false);
                break;
            case Input.Keys.RIGHT:
                screen.player.setRightMove(false);
                break;
            case Input.Keys.UP:
                screen.player.setUpMove(false);
                break;
            case Input.Keys.DOWN:
                screen.player.setDownMove(false);
                break;
        }
        return true;
    }

}
