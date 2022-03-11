package com.github.hatimiti.gamiedx.screen.field.entity.map;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

public class MapViewPoint {

	final int x;
	final int y;

	public MapViewPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean equals(final Object target) {
		if (target instanceof MapViewPoint v) {
			return this.x == v.x && this.y == v.y;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(x, y);
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
				.add("x", x)
				.add("y", y)
				.toString();
	}

}