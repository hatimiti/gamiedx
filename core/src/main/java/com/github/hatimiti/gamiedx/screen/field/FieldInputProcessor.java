package com.github.hatimiti.gamiedx.screen.field;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Input;
import com.github.hatimiti.gamiedx.DefaultInputProcessor;
import com.github.hatimiti.gamiedx.screen.field.entity.listener.MoveEventListener;
import com.github.hatimiti.gamiedx.screen.field.entity.listener.MoveEventType;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

class FieldInputProcessor extends DefaultInputProcessor {

    private final FieldScreen screen;
    private final List<MoveEventListener> moveEventListeners;

    FieldInputProcessor(Game game, FieldScreen screen) {
        super(game);
        this.screen = screen;
        this.moveEventListeners = new ArrayList<>();
    }

    @Override
    public boolean keyDown(int keycode) {
        moveEventListeners.forEach(l -> l.onMoveStarted(convertKeyCode(keycode)));
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        moveEventListeners.forEach(l -> l.onMoveStopped(convertKeyCode(keycode)));
        return true;
    }

    private MoveEventType convertKeyCode(int keycode) {
        switch (keycode)
        {
            case Input.Keys.LEFT: return MoveEventType.LEFT;
            case Input.Keys.RIGHT: return MoveEventType.RIGHT;
            case Input.Keys.UP: return MoveEventType.UP;
            case Input.Keys.DOWN: return MoveEventType.DOWN;
        }
        throw new IllegalArgumentException("Unknown keycode=" + keycode);
    }

    void addListener(@Nonnull final MoveEventListener listener) {
        this.moveEventListeners.add(listener);
    }
}
