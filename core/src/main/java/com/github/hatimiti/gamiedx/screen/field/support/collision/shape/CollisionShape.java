package com.github.hatimiti.gamiedx.screen.field.support.collision.shape;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Ellipse;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Polyline;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Shape2D;
import com.github.hatimiti.gamiedx.screen.field.value.Coordinate;
import com.github.hatimiti.gamiedx.screen.field.value.RectangleDefinition;
import com.github.hatimiti.gamiedx.type.value.Radius;

import javax.annotation.Nonnull;
import java.util.Optional;

public class CollisionShape {

    private final Shape2D shape;
    private final ShapeOperation operation;

    private CollisionShape(@Nonnull final Shape2D shape) {
        this.shape = shape;
        this.operation = createOperation(shape);
    }

    private ShapeOperation createOperation(@Nonnull final Shape2D shape) {
        // --enable-preview in Java 17
//        switch (shape) {
//            case Rectangle r: return new RectangleOperation(r);
//            case Polygon p: return new PolygonOperation(p);
//            case Polyline l: return new PolylineOperation(l);
//            case Ellipse e: return new EllipseOperation(e);
//            case Circle c: return new CircleOperation(c);
//            default: throw new IllegalStateException("Unknown shape: " + shape);
//        }
        return Optional.ofNullable((shape instanceof Rectangle r) ? new RectangleOperation(r)
                : (shape instanceof Polygon p) ? new PolygonOperation(p)
                : (shape instanceof Polyline l) ? new PolylineOperation(l)
                : (shape instanceof Ellipse e) ? new EllipseOperation(e)
                : (shape instanceof Circle c) ? new CircleOperation(c) : null)
                .orElseThrow(() -> new IllegalStateException("Unknown shape: " + shape));
    }

    public boolean intersects(final CollisionShape target) {
        return this.shape.contains(
                target.getCoordinate().getX(),
                target.getCoordinate().getY());
    }

    public Coordinate getCoordinate() {
        return this.operation.getCoordinate();
    }

    public void add(final Coordinate add) {
        this.operation.add(add);
    }

    public void sub(final Coordinate sub) {
        this.operation.sub(sub);
    }

    public static CollisionShape ofRectangle(
            @Nonnull final Coordinate point,
            @Nonnull final RectangleDefinition rectDef) {

        return new CollisionShape(new Rectangle(
                point.getX(), point.getY(),
                rectDef.getWidth(), rectDef.getHeight()));
    }

    public static CollisionShape ofCircle(
            @Nonnull final Coordinate point,
            @Nonnull final Radius radius) {
        return new CollisionShape(new Circle(
                point.getX(), point.getY(),
                radius.value()));
    }

    public static CollisionShape ofPolygon(
            float[] vertices) {
        return new CollisionShape(new Polygon(vertices));
    }

    public static CollisionShape ofEllipse(
            @Nonnull final Coordinate point,
            @Nonnull final RectangleDefinition rectDef) {
        return new CollisionShape(new Ellipse(
                point.getX(), point.getY(),
                rectDef.getWidth(), rectDef.getHeight()));
    }
}
