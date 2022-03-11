package com.github.hatimiti.gamiedx.screen.field.entity.map;


/**
 * @author hatimiti
 */
public enum MapId {

	FIRST_TOWN("M0001"),
	;

	private String value;

	MapId(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}

	public static MapId getBy(final String value) {
		for (MapId id : MapId.values()) {
			if (id.getValue().equals(value)) {
				return id;
			}
		}
		return null;
	}

}
