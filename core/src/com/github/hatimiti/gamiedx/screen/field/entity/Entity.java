package com.github.hatimiti.gamiedx.screen.field.entity;

import com.badlogic.gdx.math.GridPoint2;

public abstract class Entity {

    protected final GridPoint2 point;

    protected Entity(final GridPoint2 defaultPoint) {
        this.point = defaultPoint;
    }

    public int x() {
        return point.x;
    }

    public int y() {
        return point.y;
    }

}
