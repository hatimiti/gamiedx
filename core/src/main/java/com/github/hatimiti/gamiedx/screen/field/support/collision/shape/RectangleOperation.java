package com.github.hatimiti.gamiedx.screen.field.support.collision.shape;

import com.badlogic.gdx.math.Rectangle;
import com.github.hatimiti.gamiedx.screen.field.value.Coordinate;

final class RectangleOperation implements ShapeOperation {

    private final Rectangle s;

    RectangleOperation(final Rectangle s) {
        this.s = s;
    }

    @Override
    public Coordinate getCoordinate() {
        return Coordinate.of(s.getX(), s.getY());
    }
    @Override
    public void add(Coordinate add) {
        s.setPosition(s.getX() + add.getX(), s.getY() + add.getY());
    }
    @Override
    public void sub(Coordinate sub) {
        s.setPosition(s.getX() - sub.getX(), s.getY() - sub.getY());
    }
}
