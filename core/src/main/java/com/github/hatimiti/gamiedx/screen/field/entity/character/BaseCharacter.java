package com.github.hatimiti.gamiedx.screen.field.entity.character;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.github.hatimiti.gamiedx.screen.field.entity.Entity;
import com.github.hatimiti.gamiedx.screen.field.support.collision.shape.CollisionShape;
import com.github.hatimiti.gamiedx.screen.field.value.Coordinate;
import com.github.hatimiti.gamiedx.screen.field.value.RectangleDefinition;

import javax.annotation.Nonnull;

abstract class BaseCharacter extends Entity {

    // Constant rows and columns of the sprite sheet
    private static final int FRAME_COLS = 6, FRAME_ROWS = 5;

    private final Animation<TextureRegion> walkAnimation; // Must declare frame type (TextureRegion)
    private final Texture walkSheet;
    // A variable for tracking elapsed time for the animation
    private float stateTime;

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

        walkSheet = new Texture("animation_sheet.png");

        // Use the split utility method to create a 2D array of TextureRegions. This is
        // possible because this sprite sheet contains frames of equal size and they are
        // all aligned.
        TextureRegion[][] tmp = TextureRegion.split(walkSheet,
                walkSheet.getWidth() / FRAME_COLS,
                walkSheet.getHeight() / FRAME_ROWS);

        // Place the regions into a 1D array in the correct order, starting from the top
        // left, going across first. The Animation constructor requires a 1D array.
        TextureRegion[] walkFrames = new TextureRegion[FRAME_COLS * FRAME_ROWS];
        int index = 0;
        for (int i = 0; i < FRAME_ROWS; i++) {
            for (int j = 0; j < FRAME_COLS; j++) {
                walkFrames[index++] = tmp[i][j];
            }
        }

        // Initialize the Animation with the frame interval and array of frames
        walkAnimation = new Animation<>(0.025f, walkFrames);

        // Instantiate a SpriteBatch for drawing and reset the elapsed animation
        // time to 0
        stateTime = 0f;
    }

    @Override
    public void render(Batch batch) {
        updateMotion();
        stateTime += Gdx.graphics.getDeltaTime(); // Accumulate elapsed animation time
        // Get current frame of animation for the current stateTime
        TextureRegion currentFrame = walkAnimation.getKeyFrame(stateTime, true);
        batch.draw(currentFrame, shape.getCoordinate().getX(), shape.getCoordinate().getY()); // Draw current frame at (50, 50)
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

    protected void updateMotion() {
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
}
