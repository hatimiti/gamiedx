package com.github.hatimiti.gamiedx.screen.field.entity;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.github.hatimiti.gamiedx.screen.field.support.collision.shape.CollisionShape;
import com.github.hatimiti.gamiedx.screen.field.value.EntityId;

import javax.annotation.Nonnull;

public abstract class Entity {

    protected final CollisionShape shape;

    protected Entity(
            @Nonnull final CollisionShape shape) {
        this.shape = shape;
    }

    public EntityId getEntityId() {
        return EntityId.NONE;
    }

    /**
     * When this method returns false, this entity will be removed from the game.
     * @return If this entity is existing in game, it returns ture, but otherwise returns false.
     */
    public abstract boolean existsInGame();

    public abstract void render(Batch g);
    public abstract void update(EntityContainer ec);

    // TODO protected
    public CollisionShape getCollisionShape() {
        return shape;
    }

}
