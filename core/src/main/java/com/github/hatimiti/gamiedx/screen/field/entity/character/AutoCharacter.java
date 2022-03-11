package com.github.hatimiti.gamiedx.screen.field.entity.character;

import com.github.hatimiti.gamiedx.screen.field.entity.EntityContainer;
import com.github.hatimiti.gamiedx.screen.field.support.AutoMover;
import com.github.hatimiti.gamiedx.screen.field.value.Coordinate;

public class AutoCharacter extends BaseCharacter {

	protected AutoMover autoMover;

	public AutoCharacter(
			AutoMover autoMover,
			Coordinate defaultPoint) {

	    super(defaultPoint);

//		super(characterNumber, defaultPoint);
		this.autoMover = autoMover;
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
        autoMover.update(this);

//		}

	}

	@Override
	protected double moveSpeed() {
		return 0.1;
	}

	@Override
	public boolean existsInGame() {
		return true;
	}

	@Override
	public void update(EntityContainer ec) {

	}
}