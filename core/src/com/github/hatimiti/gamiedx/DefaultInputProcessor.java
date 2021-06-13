package com.github.hatimiti.gamiedx;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

public class DefaultInputProcessor implements InputProcessor {

    private GamieApplication game;

    public DefaultInputProcessor(final GamieApplication game) {
        this.game = game;
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode)
        {
            case Input.Keys.LEFT:
                game.character.setLeftMove(true);
                break;
            case Input.Keys.RIGHT:
                game.character.setRightMove(true);
                break;
            case Input.Keys.UP:
                game.character.setUpMove(true);
                break;
            case Input.Keys.DOWN:
                game.character.setDownMove(true);
                break;
        }
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        switch (keycode)
        {
            case Input.Keys.LEFT:
                game.character.setLeftMove(false);
                break;
            case Input.Keys.RIGHT:
                game.character.setRightMove(false);
                break;
            case Input.Keys.UP:
                game.character.setUpMove(false);
                break;
            case Input.Keys.DOWN:
                game.character.setDownMove(false);
                break;
        }
        return true;
    }


    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
