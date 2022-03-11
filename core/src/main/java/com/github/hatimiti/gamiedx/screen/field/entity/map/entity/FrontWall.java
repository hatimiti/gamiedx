package com.github.hatimiti.gamiedx.screen.field.entity.map.entity;

import com.github.hatimiti.gamiedx.screen.field.support.collision.shape.CollisionShape;

public final class FrontWall extends Wall {

	private FrontWall(float... vertices) {
		super(CollisionShape.ofPolygon(vertices));
	}

	public static FrontWall ofDefault() {
		return new FrontWall(0, 580,
				800, 580,
				800, 600,
				0, 600);
	}

}