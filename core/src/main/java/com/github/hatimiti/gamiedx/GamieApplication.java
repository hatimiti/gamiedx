package com.github.hatimiti.gamiedx;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.github.hatimiti.gamiedx.screen.field.FieldScreen;

public class GamieApplication extends Game {

//	private static final Map<Screens, Screen> SCREEN_MAP = Map.of(Screens.FIELD, new FieldScreen(this));

//	private World world;

	@Override
	public void create() {
	    Gdx.app.setLogLevel(Application.LOG_INFO);
		// for adding to judge collisions of each game object
//		world = new World(new Vector2(0, 0), false);

		FieldScreen screen = new FieldScreen(this);
		screen.create();
		setScreen(screen);
	}

	@Override
	public void render() {

//		batch.disableBlending();
//		batch.draw(img, 0, 0);
//        sprite.setColor(1, 0, 1, 1);
//        sprite.draw(batch);
		getScreen().render(Gdx.graphics.getDeltaTime());

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
	    getScreen().dispose();
	}
}