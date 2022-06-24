package com.github.hatimiti.gamiedx.screen.field.support.animation;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.github.hatimiti.gamiedx.screen.field.value.Coordinate;
import com.github.hatimiti.gamiedx.screen.field.value.RectangleDefinition;

public class WalkingAnimation {

    private RectangleDefinition rectangle;

    // A variable for tracking elapsed time for the animation
    private float stateTime;
    private final Animation<TextureRegion> walkAnimation; // Must declare frame type (TextureRegion)
    private final Texture walkSheet;

    public WalkingAnimation(final String internalPath, final int col, final int row) {
        walkSheet = new Texture(internalPath);
        final int width = walkSheet.getWidth() / col;
        final int height = walkSheet.getHeight() / row;

        rectangle = RectangleDefinition.of(width, height);

        // Use the split utility method to create a 2D array of TextureRegions. This is
        // possible because this sprite sheet contains frames of equal size and they are
        // all aligned.
        TextureRegion[][] tmp = TextureRegion.split(walkSheet, width, height);

        // Place the regions into a 1D array in the correct order, starting from the top
        // left, going across first. The Animation constructor requires a 1D array.
        TextureRegion[] walkFrames = new TextureRegion[col * row];
        int index = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                walkFrames[index++] = tmp[i][j];
            }
        }

        // Initialize the Animation with the frame interval and array of frames
        walkAnimation = new Animation<>(0.025f, walkFrames);

        // Instantiate a SpriteBatch for drawing and reset the elapsed animation
        // time to 0
        stateTime = 0f;
    }

    public void draw(final Batch batch, final Coordinate point) {
        stateTime += Gdx.graphics.getDeltaTime(); // Accumulate elapsed animation time
        // Get current frame of animation for the current stateTime
        TextureRegion currentFrame = walkAnimation.getKeyFrame(stateTime, true);
        batch.draw(currentFrame, point.getX(), point.getY()); // Draw current frame at (50, 50)
    }
}
