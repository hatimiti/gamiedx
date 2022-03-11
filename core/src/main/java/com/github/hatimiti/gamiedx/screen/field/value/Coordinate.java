package com.github.hatimiti.gamiedx.screen.field.value;

import com.github.hatimiti.gamiedx.type.BiValueType;

public class Coordinate extends BiValueType<Float, Float> {

    private final float x;
    private final float y;

    private Coordinate(final float x, final float y) {
        this.x = x;
        this.y = y;
    }

    public static Coordinate of(final float x, final float y) {
        return new Coordinate(x, y);
    }

    public float getX() {
        return val1();
    }

    public float getY() {
        return val2();
    }

    @Override
    protected Float val1() {
        return this.x;
    }

    @Override
    protected Float val2() {
        return this.y;
    }
}
