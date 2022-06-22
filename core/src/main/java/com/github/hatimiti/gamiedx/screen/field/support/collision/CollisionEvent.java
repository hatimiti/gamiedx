package com.github.hatimiti.gamiedx.screen.field.support.collision;

import com.github.hatimiti.gamiedx.screen.field.entity.Entity;
import com.github.hatimiti.gamiedx.screen.field.support.collision.shape.CollisionShape;
import com.github.hatimiti.gamiedx.screen.field.value.Coordinate;

import java.util.Objects;

public class CollisionEvent {

	/** The self entity on this collision. */
	protected final Entity self;
	/** The target entity on this collision. */
	protected final Entity target;

	/** The shape of self entity on this collision. */
	protected final CollisionShape selfShape;
	/** The shape of target entity on this collision. */
	protected final CollisionShape targetShape;

	/** The point on this collision. */
	protected final Coordinate point;

	/** The vector on this collision. */
	protected final CollisionVector vector;

	public CollisionEvent(
			final Entity self,
			final Entity target,
			final CollisionShape selfShape,
			final CollisionShape targetShape,
			final Coordinate point) {

		this.self = self;
		this.target = target;
		this.selfShape = selfShape;
		this.targetShape = targetShape;
		this.point = point;

		this.vector = null; // TODO
	}

	public Entity getSelf() {
		return this.self;
	}

	public Entity getTarget() {
		return this.target;
	}

	public CollisionShape getSelfShape() {
		return selfShape;
	}

	public CollisionShape getTargetShape() {
		return targetShape;
	}

	public Coordinate getCollitionPoint() {
		return this.point;
	}

	public int getCenterX() {
		return (int) getCollitionPoint().getX();
	}
	
	public int getCenterY() {
		return (int) getCollitionPoint().getY();
	}

	public CollisionVector getVector() {
		return vector;
	}

	public CollisionEvent reverse() {
		CollisionEvent rev = new CollisionEvent(
				this.target,
				this.self,
				this.targetShape,
				this.selfShape,
				this.point);
		return rev;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof CollisionEvent)) {
			return false;
		}
		final CollisionEvent that = (CollisionEvent) o;

		final boolean isEq1 = Objects.equals(this.self, that.self)
				&& Objects.equals(this.self, that.self);
		final boolean isEq2 = Objects.equals(this.self, that.target)
				&& Objects.equals(this.target, that.self);

		return isEq1 || isEq2;
	}

	@Override
	public int hashCode() {
		return Objects.hash(
				this.self.hashCode(), this.target.hashCode());
	}

	@Override
	public String toString() {
		// TODO to implement
		return "(TODO)";
	}
}