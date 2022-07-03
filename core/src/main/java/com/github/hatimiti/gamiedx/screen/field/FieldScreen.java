package com.github.hatimiti.gamiedx.screen.field;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.github.hatimiti.gamiedx.screen.DefaultScreen;
import com.github.hatimiti.gamiedx.screen.field.entity.EntityContainer;
import com.github.hatimiti.gamiedx.support.GameContainer;

public class FieldScreen extends DefaultScreen {

    private GameContainer gameContainer;
    private final FieldInputProcessor inputProcessor;
    final EntityContainer entityContainer;

    public FieldScreen(
            final Game game,
            final GameContainer gameContainer,
            final EntityContainer entityContainer) {
        super(game);
        this.gameContainer = gameContainer;
        this.inputProcessor = new FieldInputProcessor(game, this);
        this.entityContainer = entityContainer;
        this.inputProcessor.addListener(entityContainer);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        entityContainer.update();
        gameContainer.beginRendering();
        entityContainer.render(gameContainer);
        gameContainer.endRendering();
    }

    @Override
    public void dispose() {
        gameContainer.close();
    }
}
