package com.github.hatimiti.gamiedx.screen.field.support.move;

import com.github.hatimiti.gamiedx.screen.field.entity.character.AutoCharacter;
import com.github.hatimiti.gamiedx.screen.field.entity.character.Player;

import javax.annotation.Nonnull;

/**
 * The strategy which approaches to player automatically.
 * @author hatimiti
 *
 */
public class AutoApproachMover
		implements AutoMover {

	private AutoCharacter origin;

	public AutoApproachMover(@Nonnull final AutoCharacter origin) {
		this.origin = origin;
	}

	@Override
	public void update(final Player target) {

		float tx = target.getCollisionShape().getCoordinate().getX();
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

		float ty = target.getCollisionShape().getCoordinate().getY();
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