package com.github.hatimiti.gamiedx.screen.field.support.collision.shape;

import com.badlogic.gdx.math.Ellipse;
import com.github.hatimiti.gamiedx.screen.field.value.Coordinate;

final class EllipseOperation implements ShapeOperation {

    private final Ellipse s;

    EllipseOperation(final Ellipse s) {
        this.s = s;
    }

    @Override
    public Coordinate getCoordinate() {
        return Coordinate.of(s.x, s.y);
    }
    @Override
    public void add(Coordinate add) {
        s.setPosition(s.x + add.getX(), s.y + add.getY());
    }
    @Override
    public void sub(Coordinate sub) {
        s.setPosition(s.x - sub.getX(), s.y - sub.getY());
    }
}
