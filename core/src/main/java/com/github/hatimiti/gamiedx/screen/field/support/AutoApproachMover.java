package com.github.hatimiti.gamiedx.screen.field.support;

import com.github.hatimiti.gamiedx.screen.field.entity.character.AutoCharacter;
import com.github.hatimiti.gamiedx.screen.field.entity.character.Player;

/**
 * The strategy which approaches to player automatically.
 * @author hatimiti
 *
 */
public class AutoApproachMover
		implements AutoMover {

	@Override
	public void update(
			final AutoCharacter target,
			final Player player) {

		float px = player.x();
		float tx = target.x();
		int dx = 0;

		if (tx < px) {
			dx = 5;
			target.setRightMove(true);
			target.setLeftMove(false);
		} else if (px < tx) {
			dx = -5;
			target.setRightMove(false);
			target.setLeftMove(true);
		}

		float py = player.y();
		float ty = target.y();
		int dy = 0;

		if (ty < py) {
			dy = 5;
			target.setDownMove(false);
			target.setUpMove(true);
		} else if (py < ty) {
			dy = -5;
			target.setDownMove(true);
			target.setUpMove(false);
		}

//		FacingDirection d = FacingDirection.getBy(dx | dy);
//		target.faceTo(d);
//		target.move();

	}

}