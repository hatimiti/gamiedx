package com.github.hatimiti.gamiedx.screen.field.support.collision.shape;

import com.github.hatimiti.gamiedx.screen.field.value.Coordinate;

interface ShapeOperation {
    Coordinate getCoordinate();
    void add(Coordinate add);
    void sub(Coordinate sub);
}
