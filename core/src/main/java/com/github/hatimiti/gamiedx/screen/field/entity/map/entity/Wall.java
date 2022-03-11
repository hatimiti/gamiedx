package com.github.hatimiti.gamiedx.screen.field.entity.map.entity;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.github.hatimiti.gamiedx.screen.field.entity.Entity;
import com.github.hatimiti.gamiedx.screen.field.entity.EntityContainer;
import com.github.hatimiti.gamiedx.screen.field.support.collision.shape.CollisionShape;

import javax.annotation.Nonnull;

abstract class Wall extends Entity {
	protected Wall(@Nonnull CollisionShape shape) {
		super(shape);
	}

	@Override
	public boolean existsInGame() {
		return true;
	}

	@Override
	public void render(Batch g) {
	}

	@Override
	public void update(EntityContainer ec) {
	}
}