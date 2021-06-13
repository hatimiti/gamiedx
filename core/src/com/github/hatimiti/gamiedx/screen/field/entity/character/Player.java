package com.github.hatimiti.gamiedx.screen.field.entity.character;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Player {

    private int x = 50;
    private int y = 50;

    private boolean isLeftMove;
    private boolean isRightMove;

    private boolean isUpMove;
    private boolean isDownMove;

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

    // Constant rows and columns of the sprite sheet
    private static final int FRAME_COLS = 6, FRAME_ROWS = 5;

    private Animation<TextureRegion> walkAnimation; // Must declare frame type (TextureRegion)
    private Texture walkSheet;
    // A variable for tracking elapsed time for the animation
    private float stateTime;

    public Player() {
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

    void updateMotion() {
        int dx = (int) Math.ceil(5.0 * Gdx.graphics.getDeltaTime());
        if (isLeftMove) {
            x -= dx;
        }
        if (isRightMove) {
            x += dx;
        }

        int dy = (int) Math.ceil(5.0 * Gdx.graphics.getDeltaTime());
        if (isUpMove) {
            y += dy;
        }
        if (isDownMove) {
            y -= dy;
        }
    }

    public void render(SpriteBatch batch) {
        updateMotion();
        stateTime += Gdx.graphics.getDeltaTime(); // Accumulate elapsed animation time
        // Get current frame of animation for the current stateTime
        TextureRegion currentFrame = walkAnimation.getKeyFrame(stateTime, true);
        batch.draw(currentFrame, x, y); // Draw current frame at (50, 50)
    }

}
