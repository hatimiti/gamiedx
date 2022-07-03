package com.github.hatimiti.gamiedx.screen.field.entity.map.entity;

import com.github.hatimiti.gamiedx.screen.field.entity.Entity;
import com.github.hatimiti.gamiedx.screen.field.entity.EntityContainer;
import com.github.hatimiti.gamiedx.screen.field.support.collision.CollisionEvent;
import com.github.hatimiti.gamiedx.screen.field.support.collision.shape.CollisionShape;
import com.github.hatimiti.gamiedx.support.GameContainer;

import javax.annotation.Nonnull;

abstract sealed class Wall extends Entity
		permits BackWall, FrontWall, LeftWall, RightWall {

	protected Wall(@Nonnull CollisionShape shape) {
		super(shape);
	}

	@Override
	public boolean existsInGame() {
		return true;
	}

	@Override
	public void render(GameContainer g) {
	}

	@Override
	public void update(EntityContainer ec) {
	}

	@Override
	public void onCollision(CollisionEvent event) {

	}

	@Override
	public void onCollisionFree() {

	}
}