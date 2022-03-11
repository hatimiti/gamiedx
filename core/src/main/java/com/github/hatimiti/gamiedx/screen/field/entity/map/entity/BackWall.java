package com.github.hatimiti.gamiedx.screen.field.entity.map.entity;

import com.github.hatimiti.gamiedx.screen.field.support.collision.shape.CollisionShape;

public final class BackWall extends Wall {

	private BackWall(float... vertices) {
		super(CollisionShape.ofPolygon(vertices));
	}

	public static BackWall ofDefault() {
		return new BackWall(120, 0,
				680, 0,
				680, 240,
				120, 240);
	}

}