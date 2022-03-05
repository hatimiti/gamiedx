package com.github.hatimiti.gamiedx.screen.field.support;

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
	void update(AutoCharacter target, Player player);

}
