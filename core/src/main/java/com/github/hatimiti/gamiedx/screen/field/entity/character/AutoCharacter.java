package com.github.hatimiti.gamiedx.screen.field.entity.character;

import com.github.hatimiti.gamiedx.screen.field.entity.EntityContainer;
import com.github.hatimiti.gamiedx.screen.field.support.move.AutoApproachMover;
import com.github.hatimiti.gamiedx.screen.field.support.move.AutoMover;
import com.github.hatimiti.gamiedx.screen.field.value.Coordinate;

public class AutoCharacter extends BaseCharacter {

	protected AutoMover autoMover;

	public AutoCharacter(
			Coordinate defaultPoint) {

	    super(defaultPoint);
		this.autoMover = new AutoApproachMover(this);
	}

	@Override
	public void update(EntityContainer container) {
		autoMover.update(container.getPlayer());
		super.update(container);
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

}