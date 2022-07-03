package com.github.hatimiti.gamiedx.support;

import com.badlogic.gdx.graphics.g2d.Batch;

public interface GameContainer {

    Batch getGraphic();
    boolean isDebugMode();
    void beginRendering();
    void endRendering();
    void close();
}
