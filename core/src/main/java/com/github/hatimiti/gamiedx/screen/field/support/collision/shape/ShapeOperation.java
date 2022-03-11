package com.github.hatimiti.gamiedx.screen.field.support.collision.shape;

import com.github.hatimiti.gamiedx.screen.field.value.Coordinate;

sealed interface ShapeOperation
        permits CircleOperation, EllipseOperation,
        PolygonOperation, PolylineOperation, RectangleOperation {

    Coordinate getCoordinate();
    void add(Coordinate add);
    void sub(Coordinate sub);
}
