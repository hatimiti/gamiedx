package com.github.hatimiti.gamiedx.screen.field.support.move;

import com.github.hatimiti.gamiedx.screen.field.entity.character.AutoCharacter;
import com.github.hatimiti.gamiedx.screen.field.entity.character.Player;

/**
 * Defines to move for characters (Pattern of Strategy)
 * @author hatimiti
 *
 */
@FunctionalInterface
public interface AutoMover {

	// TODO How should we pass other than a player(EntityList?)
	void update(final Player target);

}
