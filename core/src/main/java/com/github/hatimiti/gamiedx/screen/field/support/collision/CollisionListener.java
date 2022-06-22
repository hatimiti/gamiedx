package com.github.hatimiti.gamiedx.screen.field.support.collision;

import com.github.hatimiti.gamiedx.screen.field.support.collision.shape.CollisionShape;


public interface CollisionListener {

	/**
	 * It should be implemented with the process on the collision occurred.
	 * @param event the occurred event.
	 */
	void onCollision(CollisionEvent event);

	/** It should be implemented with the process on the collision-free. */
	void onCollisionFree();

	/**
	 * Return shapes related to the collision event.
	 * @return shapes
	 */
	CollisionShape[] getCollisionShapes();

}