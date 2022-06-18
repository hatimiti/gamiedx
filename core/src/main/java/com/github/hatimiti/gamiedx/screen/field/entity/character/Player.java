package com.github.hatimiti.gamiedx.screen.field.entity.character;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.github.hatimiti.gamiedx.screen.field.entity.EntityContainer;
import com.github.hatimiti.gamiedx.screen.field.value.Coordinate;

public class Player extends BaseCharacter {

    public Player(final Coordinate defaultPoint) {
        super(defaultPoint);
    }

    @Override
    public void render(Batch batch) {
        super.render(batch);
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
