package com.github.hatimiti.gamiedx.screen.field.entity.map.entity;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.github.hatimiti.gamiedx.screen.field.entity.Entity;
import com.github.hatimiti.gamiedx.screen.field.entity.EntityContainer;
import com.github.hatimiti.gamiedx.screen.field.entity.map.MapId;
import com.github.hatimiti.gamiedx.screen.field.entity.map.MapViewPoint;
import com.github.hatimiti.gamiedx.screen.field.support.collision.CollisionEvent;
import com.github.hatimiti.gamiedx.screen.field.support.collision.shape.CollisionShape;
import com.github.hatimiti.gamiedx.screen.field.value.Coordinate;
import com.github.hatimiti.gamiedx.screen.field.value.RectangleDefinition;
import com.github.hatimiti.gamiedx.support.GameContainer;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.util.Arrays;
import java.util.List;

public class MapView extends Entity {

	protected Texture image;

	/** The ID of this view. */
	protected MapId mapId;
	/** The point of this view. */
	protected MapViewPoint point;

	protected List<Wall> walls;

	public MapView(
			final MapId mapId,
			final MapViewPoint point,
			final Texture background) {

		super(CollisionShape.ofRectangle(
				Coordinate.of(0, 0),
				RectangleDefinition.of(800, 600)));
		init(mapId, point,
				background,
				BackWall.ofDefault(),
				RightWall.ofDefault(),
				FrontWall.ofDefault(),
				LeftWall.ofDefault());
	}

	protected void init(
			final MapId mapId,
			final MapViewPoint point,
			final Texture background,
			final BackWall backWall,
			final RightWall rightWall,
			final FrontWall frontWall,
			final LeftWall leftWall) {

		this.mapId = mapId;
		this.point = point;
		this.image = background;
		this.walls = Arrays.asList(backWall, rightWall, frontWall, leftWall);
	}

	public MapViewPoint getViewPoint() {
		return this.point;
	}

	@Override
	public void render(final GameContainer g) {
//		this.image.draw();
		g.getGraphic().setColor(Color.RED);
		walls.forEach(w -> w.render(g));
	}

	@Override

	public void update(EntityContainer ec) {
	}

	@Override
	public boolean equals(final Object o) {
		if (!(o instanceof MapView)) {
			return false;
		}
		MapView target = (MapView) o;

		return Objects.equal(this.mapId, target.mapId)
				&& Objects.equal(this.point, target.point);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.mapId, this.point);
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
				.add("mapId", mapId)
				.add("point", point)
				.add("walls", walls)
				.toString();
	}

	@Override
	public boolean existsInGame() {
		return true;
	}

	@Override
	public void onCollision(CollisionEvent event) {
	}

	@Override
	public void onCollisionFree() {
	}
}