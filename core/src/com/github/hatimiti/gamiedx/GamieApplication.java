package com.github.hatimiti.gamiedx;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.World;
import com.github.hatimiti.gamiedx.state.field.entity.character.Character;

public class GamieApplication extends Game {

	private SpriteBatch batch;
	private Texture img;

	Character character;

//	private World world;

	@Override
	public void create() {
//		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		character = new Character();

		// for adding to judge collisions of each game object
//		world = new World(new Vector2(0, 0), false);

		batch = new SpriteBatch();
		// input for keyboard
		final var inputProcessor = new DefaultInputProcessor(this);
	}

	@Override
	public void render() {
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
		character.render(batch);
		batch.end();

//		BodyDef bodyDef = new BodyDef();
//		bodyDef.type = BodyDef.BodyType.DynamicBody;
//		bodyDef.position.set(100, 300);
//
//		Body body = world.createBody(bodyDef);
//		CircleShape circle = new CircleShape();
//		circle.setRadius(6f);
//
//		FixtureDef fixtureDef = new FixtureDef();
//		fixtureDef.shape = circle;
//		fixtureDef.density = 0.5f;
//		fixtureDef.friction = 0.4f;
//		fixtureDef.restitution = 0.6f;
//
//		Fixture fixture = body.createFixture(fixtureDef);
//
//		fixture.setUserData();
//
//		world.step(1 / 60f, 6, 2);

	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
