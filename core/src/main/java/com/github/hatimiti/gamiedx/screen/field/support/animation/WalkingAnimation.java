package com.github.hatimiti.gamiedx.screen.field.support.animation;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.github.hatimiti.gamiedx.screen.field.value.Coordinate;
import com.github.hatimiti.gamiedx.screen.field.value.RectangleDefinition;
import com.github.hatimiti.gamiedx.support.GameContainer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WalkingAnimation {

    private static final Logger LOG = LogManager.getLogger();

    private RectangleDefinition rectangle;

    private ShapeRenderer shapeRenderer = new ShapeRenderer();

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

    public void draw(final GameContainer g, final Coordinate point) {

        if (g.isDebugMode()) {
            shapeRenderer.setTransformMatrix(g.getGraphic().getTransformMatrix());
            shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
            shapeRenderer.setColor(Color.BLUE);
            shapeRenderer.rect(point.getX(), point.getY(), rectangle.getWidth(), rectangle.getHeight());
            shapeRenderer.end();
            return;
        }

        stateTime += Gdx.graphics.getDeltaTime(); // Accumulate elapsed animation time
        // Get current frame of animation for the current stateTime
        TextureRegion currentFrame = walkAnimation.getKeyFrame(stateTime, true);
        g.getGraphic().draw(currentFrame, point.getX(), point.getY()); // Draw current frame at (50, 50)
    }
}
