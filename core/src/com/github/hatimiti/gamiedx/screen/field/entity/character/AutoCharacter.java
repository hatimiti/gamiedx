package com.github.hatimiti.gamiedx.screen.field.entity.character;

import com.badlogic.gdx.math.GridPoint2;
import com.github.hatimiti.gamiedx.screen.field.entity.Entity;
import com.github.hatimiti.gamiedx.screen.field.support.AutoMover;

public class AutoCharacter extends BaseCharacter {

	protected AutoMover autoMover;
	protected Player player;

	public AutoCharacter(
			AutoMover autoMover,
			GridPoint2 defaultPoint,
			Player player) {

	    super(defaultPoint);

//		super(characterNumber, defaultPoint);
		this.autoMover = autoMover;

		this.player = player; // FIXME remove this
	}

//	@Override

	@Override
	protected void updateMotion() {
		moveAutomation();
		super.updateMotion();
	}

	public void moveAutomation(/*EntityContainer ec*/) {

//		this.liveStatus.update();
//
//		if (isDeadStatus()) {
//			this.existsInGame = false;
//		}
//
//		if (isNotNormalStatus()) {
//			stop();
//		} else {
//			//FIXME How to pass EntityContainer
//			this.autoMover.update(this, clientEntityContainer().getPlayer());
        autoMover.update(this, player);

//		}

	}

	@Override
	protected double moveSpeed() {
		return 0.1;
	}
}