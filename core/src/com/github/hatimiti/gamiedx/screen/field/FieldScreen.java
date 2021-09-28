package com.github.hatimiti.gamiedx.screen.field;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.GridPoint2;
import com.github.hatimiti.gamiedx.screen.DefaultScreen;
import com.github.hatimiti.gamiedx.screen.field.entity.character.AutoCharacter;
import com.github.hatimiti.gamiedx.screen.field.entity.character.Player;
import com.github.hatimiti.gamiedx.screen.field.support.AutoApproachMover;

public class FieldScreen extends DefaultScreen {

    private SpriteBatch batch;
    private final InputProcessor inputProcessor;
    private Texture img;
    Player player;
    AutoCharacter enemy;

    public FieldScreen(final Game game) {
        super(game);
        this.inputProcessor = new FieldInputProcessor(game, this);
        player = new Player(new GridPoint2(50, 50));
        enemy = new AutoCharacter(new AutoApproachMover(), new GridPoint2(100, 50), player);
    }

    @Override
    public void create() {

//		batch = new SpriteBatch();
        img = new Texture("badlogic.jpg");

        batch = new SpriteBatch();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        Sprite sprite = new Sprite(img);
        sprite.setPosition(0, 100);
        sprite.setRotation(45);

        batch.begin();
//		batch.disableBlending();
//		batch.draw(img, 0, 0);
//        sprite.setColor(1, 0, 1, 1);
//        sprite.draw(batch);
        player.render(batch);
        enemy.render(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
    }
}
