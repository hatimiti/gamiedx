package com.github.hatimiti.gamiedx.screen.field.entity.character;

import com.github.hatimiti.gamiedx.screen.field.entity.EntityContainer;
import com.github.hatimiti.gamiedx.screen.field.value.Coordinate;
import com.github.hatimiti.gamiedx.support.GameContainer;

public class Player extends BaseCharacter {

    public Player(final Coordinate defaultPoint) {
        super(defaultPoint);
    }

    @Override
    public void render(GameContainer g) {
        super.render(g);
    }

    @Override
    public void update(EntityContainer ec) {
        super.update(ec);
    }

    @Override
    public boolean existsInGame() {
        return true; // TODO must be implemented
    }
}
