package com.github.hatimiti.gamiedx.screen.field.entity.map.entity;

import com.github.hatimiti.gamiedx.screen.field.support.collision.shape.CollisionShape;

public final class RightWall extends Wall {

	private RightWall(float... vertices) {
		super(CollisionShape.ofPolygon(vertices));
	}

	public static RightWall ofDefault() {
		return new RightWall(680, 0,
				800, 0,
				800, 600,
				680, 240);
	}

}