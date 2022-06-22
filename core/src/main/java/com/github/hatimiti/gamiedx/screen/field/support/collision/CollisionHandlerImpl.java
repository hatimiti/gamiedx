package com.github.hatimiti.gamiedx.screen.field.support.collision;

import com.badlogic.gdx.math.Polyline;
import com.github.hatimiti.gamiedx.screen.field.entity.Entity;
import com.github.hatimiti.gamiedx.screen.field.support.collision.shape.CollisionShape;
import com.github.hatimiti.gamiedx.screen.field.value.Coordinate;
import com.github.hatimiti.gamiedx.screen.field.value.collection.EntityList;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class CollisionHandlerImpl implements CollisionHandler {

	/** The entities collided on the previous judge */
	protected Set<Entity> preCollisionEntities = new HashSet<>();

	@Override
	public void detectCollision(final EntityList entities) {

		final Set<CollisionEvent> collision = new HashSet<>();

		entities.forEach(origin -> entities.forEach(target -> {
			if (origin.equals(target)) {
				return;/*continue*/
			}
			final CollisionJudge result = detectCollision(origin, target);
			if (result.hasCollided) {
				collision.add(new CollisionEvent(
						origin,
						target,
						result.origin,
						result.target,
						result.point));
			}
		}));

		final Set<Entity> currentCollisionEntities = new HashSet<>();
		collision.forEach(event -> {
			event.getSelf().onCollision(event);
			event.getTarget().onCollision(event.reverse());
			currentCollisionEntities.add(event.getSelf());
			currentCollisionEntities.add(event.getTarget());
		});

		final List<Entity> freedEntities = this.preCollisionEntities.parallelStream()
			.filter(currentCollisionEntities::contains)
			.collect(Collectors.toList());
		
		freedEntities.parallelStream()
			.forEach(e -> e.onCollisionFree());
		
		this.preCollisionEntities = currentCollisionEntities;
	}
	
	protected CollisionJudge detectCollision(final Entity a, final Entity b) {
		for (final CollisionShape as : a.getCollisionShapes()) {
			for (final CollisionShape bs : b.getCollisionShapes()) {
				if (as.intersects(bs)) {
					return CollisionJudge.ofCollided(as, bs);
				}
			}
		}
		return CollisionJudge.ofNotCollided();
	}


	protected static class CollisionJudge {

		private boolean hasCollided;
		private CollisionShape origin;
		private CollisionShape target;
		private Coordinate point;

		private CollisionJudge(
				final boolean hasCollided, final CollisionShape origin, final CollisionShape target) {

			this.hasCollided = hasCollided;
			this.origin = origin;
			this.target = target;

			if (origin == null || target == null) {
				return;
			}

			final Polyline line = new Polyline(new float[] {
					origin.getCoordinate().getX(),
					origin.getCoordinate().getY(),
					target.getCoordinate().getX(),
					target.getCoordinate().getY()});

			this.point = Coordinate.of(line.getX(), line.getY());
		}

		public static CollisionJudge ofCollided(final CollisionShape origin, final CollisionShape target) {
			Objects.requireNonNull(origin);
			Objects.requireNonNull(target);
			return new CollisionJudge(true, origin, target);
		}

		public static CollisionJudge ofNotCollided() {
			return new CollisionJudge(false, null, null);
		}

	}
}