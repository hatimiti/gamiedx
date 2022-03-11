package com.github.hatimiti.gamiedx.screen.field.support;

import com.github.hatimiti.gamiedx.screen.field.entity.character.AutoCharacter;
import com.github.hatimiti.gamiedx.screen.field.value.Coordinate;

/**
 * The strategy which approaches to player automatically.
 * @author hatimiti
 *
 */
public class AutoApproachMover
		implements AutoMover {

	private Coordinate approachPoint;

	public void updateApproachPoint(final Coordinate newPoint) {
		this.approachPoint = newPoint;
	}

	@Override
	public void update(final AutoCharacter origin) {

		if (approachPoint == null) {
			return;
		}

		float tx = approachPoint.getX();
		float ox = origin.getCollisionShape().getCoordinate().getX();
		int dx = 0;

		if (ox < tx) {
			dx = 5;
			origin.setRightMove(true);
			origin.setLeftMove(false);
		} else if (tx < ox) {
			dx = -5;
			origin.setRightMove(false);
			origin.setLeftMove(true);
		}

		float ty = approachPoint.getY();
		float oy = origin.getCollisionShape().getCoordinate().getY();
		int dy = 0;

		if (oy < ty) {
			dy = 5;
			origin.setDownMove(false);
			origin.setUpMove(true);
		} else if (ty < oy) {
			dy = -5;
			origin.setDownMove(true);
			origin.setUpMove(false);
		}

//		FacingDirection d = FacingDirection.getBy(dx | dy);
//		target.faceTo(d);
//		target.move();

	}

}