package com.github.hatimiti.gamiedx.type.value;

import com.github.hatimiti.gamiedx.type.BaseType;

public class Radius extends BaseType<Float> {

    private final float radius;

    public Radius(final float radius) {
        this.radius = radius;
    }

    @Override
    public Float value() {
        return this.radius;
    }

}
