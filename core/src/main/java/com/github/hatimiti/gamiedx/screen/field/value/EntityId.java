package com.github.hatimiti.gamiedx.screen.field.value;

import com.github.hatimiti.gamiedx.type.BaseType;

public final class EntityId extends BaseType<String> {

	public static final EntityId NONE = new EntityId("None");
	public static final EntityId INIT = new EntityId("Initializing");

	private final String entityId;

	public EntityId(final String entityId) {
		this.entityId = entityId;
	}

	public boolean isNone() {
		return NONE.equals(this);
	}

	public boolean isInit() {
		return INIT.equals(this);
	}

	@Override
	public String value() {
		return this.entityId;
	}

}
