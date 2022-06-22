package com.github.hatimiti.gamiedx.screen.field.support.collision;

import com.github.hatimiti.gamiedx.screen.field.support.direction.FacingDirection;

public class CollisionVector {

	/** the direction on the collision. */
	protected FacingDirection direction;
	/** the X axis power on the collision. */
	protected float collisionForceX;
	/** the Y axis power on the collision. */
	protected float collisionForceY;

	public CollisionVector(
			final FacingDirection direction,
			final float collisionForceX,
			final float collisionForceY) {
		this.direction = direction;
		this.collisionForceX = collisionForceX;
		this.collisionForceY = collisionForceY;
	}

	public FacingDirection getDirection() {
		return direction;
	}

	public float getCollisionForceX() {
		return collisionForceX;
	}

	public float getCollisionForceY() {
		return collisionForceY;
	}

}