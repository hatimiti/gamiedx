package com.github.hatimiti.gamiedx.screen.field.value;

import com.github.hatimiti.gamiedx.type.BiValueType;

public class RectangleDefinition extends BiValueType<Float, Float> {

    private final float width;
    private final float height;

    private RectangleDefinition(final float w, final float h) {
        this.width = w;
        this.height = h;
    }

    public static RectangleDefinition of(final float w, final float h) {
        return new RectangleDefinition(w, h);
    }

    public float getWidth() {
        return val1();
    }

    public float getHeight() {
        return val2();
    }

    @Override
    protected Float val1() {
        return this.width;
    }

    @Override
    protected Float val2() {
        return this.height;
    }
}
