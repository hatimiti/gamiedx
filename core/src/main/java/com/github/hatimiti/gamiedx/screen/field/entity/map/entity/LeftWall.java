package com.github.hatimiti.gamiedx.screen.field.entity.map.entity;

import com.github.hatimiti.gamiedx.screen.field.support.collision.shape.CollisionShape;

public final class LeftWall extends Wall {

	private LeftWall(float... vertices) {
		super(CollisionShape.ofPolygon(vertices));
	}

	public static LeftWall ofDefault() {
		return new LeftWall(0, 0,
				120, 0,
				120, 240,
				0, 600);
	}

}