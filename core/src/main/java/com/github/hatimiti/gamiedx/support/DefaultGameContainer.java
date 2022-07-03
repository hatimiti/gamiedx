package com.github.hatimiti.gamiedx.support;

import com.badlogic.gdx.graphics.g2d.Batch;

public class DefaultGameContainer implements GameContainer {

    private Batch batch;

    public DefaultGameContainer(final Batch batch) {
        this.batch = batch;
    }

    @Override
    public Batch getGraphic() {
        return batch;
    }

    @Override
    public boolean isDebugMode() {
        return false;
    }

    @Override
    public void beginRendering() {
        batch.begin();
    }

    @Override
    public void endRendering() {
        batch.end();
    }

    @Override
    public void close() {
        batch.dispose();
    }
}
