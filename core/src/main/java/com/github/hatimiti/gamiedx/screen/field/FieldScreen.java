package com.github.hatimiti.gamiedx.screen.field;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.github.hatimiti.gamiedx.screen.DefaultScreen;
import com.github.hatimiti.gamiedx.screen.field.entity.EntityContainer;
import com.github.hatimiti.gamiedx.screen.field.entity.character.AutoCharacter;
import com.github.hatimiti.gamiedx.screen.field.entity.character.Player;
import com.github.hatimiti.gamiedx.screen.field.support.AutoApproachMover;
import com.github.hatimiti.gamiedx.screen.field.value.Coordinate;

import javax.annotation.Nonnull;

public class FieldScreen extends DefaultScreen {

    private Batch batch;
    private final InputProcessor inputProcessor;
    final EntityContainer container;

    public FieldScreen(final Game game, final EntityContainer container) {
        super(game);
        this.inputProcessor = new FieldInputProcessor(game, this);
        this.container = container;
    }

    @Override
    public void create(@Nonnull final Batch batch) {
        this.batch = batch;
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
//		batch.disableBlending();
//		batch.draw(img, 0, 0);
//        sprite.setColor(1, 0, 1, 1);
//        sprite.draw(batch);
        container.render(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
