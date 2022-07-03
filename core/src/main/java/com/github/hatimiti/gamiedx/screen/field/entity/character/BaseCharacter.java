package com.github.hatimiti.gamiedx.screen.field.entity.character;

import com.badlogic.gdx.Gdx;
import com.github.hatimiti.gamiedx.screen.field.entity.Entity;
import com.github.hatimiti.gamiedx.screen.field.entity.EntityContainer;
import com.github.hatimiti.gamiedx.screen.field.support.animation.WalkingAnimation;
import com.github.hatimiti.gamiedx.screen.field.support.collision.CollisionEvent;
import com.github.hatimiti.gamiedx.screen.field.support.collision.shape.CollisionShape;
import com.github.hatimiti.gamiedx.screen.field.value.Coordinate;
import com.github.hatimiti.gamiedx.screen.field.value.RectangleDefinition;
import com.github.hatimiti.gamiedx.support.GameContainer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Nonnull;

abstract class BaseCharacter extends Entity {

    private static final Logger LOG = LogManager.getLogger();

    // Constant rows and columns of the sprite sheet
    private static final int FRAME_COLS = 6, FRAME_ROWS = 5;

    private final WalkingAnimation walkingAnimation;

    private boolean isLeftMove;
    private boolean isRightMove;

    private boolean isUpMove;
    private boolean isDownMove;

    protected double moveSpeed() {
        return 500;
    }

    protected BaseCharacter(@Nonnull final Coordinate point) {
        super(CollisionShape.ofRectangle(
                point, RectangleDefinition.of(20, 32)));

        walkingAnimation = new WalkingAnimation("animation_sheet.png", FRAME_COLS, FRAME_ROWS);
    }

    @Override
    public void render(GameContainer g) {
        walkingAnimation.draw(g, shape.getCoordinate());
    }

    public void setLeftMove(final boolean t) {
        if(isRightMove && t) isRightMove = false;
        isLeftMove = t;
    }
    public void setRightMove(final boolean t) {
        if(isLeftMove && t) isLeftMove = false;
        isRightMove = t;
    }

    public void setUpMove(final boolean t) {
        if(isDownMove && t) isDownMove = false;
        isUpMove = t;
    }
    public void setDownMove(final boolean t) {
        if(isUpMove && t) isUpMove = false;
        isDownMove = t;
    }

    @Override
    public void update(EntityContainer container) {
        int dx = (int) Math.ceil(moveSpeed() * Gdx.graphics.getDeltaTime());
        if (isLeftMove) {
            shape.sub(Coordinate.of(dx, 0));
        }
        if (isRightMove) {
            shape.add(Coordinate.of(dx, 0));
        }

        int dy = (int) Math.ceil(moveSpeed() * Gdx.graphics.getDeltaTime());
        if (isUpMove) {
            shape.add(Coordinate.of(0, dy));
        }
        if (isDownMove) {
            shape.sub(Coordinate.of(0, dy));
        }

        Gdx.app.debug("PLAYER", String.format("dx=%s, dy=%s",dx, dy));
    }

    @Override
    public void onCollision(CollisionEvent event) {
        LOG.info("Collision: {}", event);
    }

    @Override
    public void onCollisionFree() {
        LOG.info("Collision free");
    }
}
