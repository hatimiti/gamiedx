package com.github.hatimiti.gamiedx.screen.field.entity;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.github.hatimiti.gamiedx.screen.field.entity.character.AutoCharacter;
import com.github.hatimiti.gamiedx.screen.field.entity.character.Player;
import com.github.hatimiti.gamiedx.screen.field.entity.map.MapId;
import com.github.hatimiti.gamiedx.screen.field.entity.map.MapViewPoint;
import com.github.hatimiti.gamiedx.screen.field.entity.map.entity.MapView;
import com.github.hatimiti.gamiedx.screen.field.support.AutoApproachMover;
import com.github.hatimiti.gamiedx.screen.field.value.Coordinate;
import com.github.hatimiti.gamiedx.screen.field.value.collection.EntityList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class EntityContainer {

	private static final Logger LOG = LogManager.getLogger();

	private Player player;
	protected Map<MapView, EntityContainerByTile> containerMap;

	public EntityContainer() {
		this.containerMap = new HashMap<>();
	}

	public void load() {
		// TODO
		final var viewPoint = new MapViewPoint(0, 0);
		final var defaultView = new MapView(MapId.FIRST_TOWN, viewPoint, null);
		player = new Player(Coordinate.of(50, 50));
		add(player, defaultView);

		final AutoApproachMover autoMover = new AutoApproachMover();
		autoMover.updateApproachPoint(player.getCollisionShape().getCoordinate());
		add(new AutoCharacter(autoMover, Coordinate.of(100, 50)), defaultView);
	}

	public boolean add(final Entity entity, final MapView view) {
		return getEntityListIn(view).add(entity);
	}

	public void render(final Batch batch) {

		containerMap.forEach((k, v) -> {
			v.entities.render(batch);
		});
	}

//	public void update(final MapView view, final ExchangePlayer player) {
//
//		EntityId eid = new EntityId(player.eid);
//
//		//FIXME メインキャラ以外の更新も必要
//		Optional<Entity> entity = getEntityListIn(view).findEntity(eid);
//
//		if (entity.isPresent()) {
//			entity.get().positionAt(Point.at(player.x, player.y));
//			entity.get().faceTo(FacingDirection.getBy(player.d));
//
//		} else {
////			OnlinePlayer c = new OnlinePlayer(101, Point.at(player.x, player.y));
////			c.entityId = eid;
////			addTo(tile, c);
////
////			LOG.info("{} さんが参加しました", player.eid);
//		}
//	}

	public Player getPlayer() {
		return this.player;
	}

	public EntityList getEntityListIn(final MapView view) {
		return get(view).entities;
	}

	public void clearEntities() {
		this.containerMap.clear();
	}

	public void clearEntitiesIn(final MapView view) {
		this.get(view).entities.clear();
	}

	protected EntityContainerByTile get(final MapView view) {
		EntityContainerByTile c = this.containerMap.get(view);
		if (c == null) {
			c = new EntityContainerByTile(view);
			this.containerMap.put(view, c);
		}
		return c;
	}

	protected class EntityContainerByTile {
		protected MapView view;
		protected EntityList entities;

		public EntityContainerByTile(final MapView view) {
			this.view = view;
			this.entities = new EntityList();
		}
	}
}