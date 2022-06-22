package com.github.hatimiti.gamiedx.screen.field.value.collection;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.github.hatimiti.gamiedx.screen.field.entity.Entity;
import com.github.hatimiti.gamiedx.screen.field.entity.EntityContainer;
import com.github.hatimiti.gamiedx.screen.field.support.collision.CollisionHandler;
import com.github.hatimiti.gamiedx.screen.field.value.EntityId;
import com.github.hatimiti.gamiedx.type.SyncListType;

import java.util.Objects;
import java.util.Optional;

public final class EntityList extends SyncListType<Entity> {

	/** Judge collision */
	private CollisionHandler collisionHandler;

	public EntityList(final CollisionHandler collisionHandler) {
		this.collisionHandler = collisionHandler;
	}

	public void render(final Batch g) {
		this.stream()
			.forEach(v -> v.render(g));
	}

	public void update(final EntityContainer entityContainer) {

		removeNonExistsEntities();

		this.parallelStream()
			.forEach(v -> v.update(entityContainer));

		this.collisionHandler.detectCollision(this);
	}

	public Optional<Entity> findEntity(final EntityId entityId) {
		return this.stream()
				.filter(e -> entityId.equals(e.getEntityId()))
				.findFirst();
	}
	
	@Override
	public void clear() {
		super.clear();
//		this.collisionHandler.clear();
	}

	private void removeNonExistsEntities() {
		removeAllIf(v -> !v.existsInGame());
	}

	@Override
	public boolean add(final Entity entity) {
		Objects.requireNonNull(entity);
		return super.add(entity);
	}
}
