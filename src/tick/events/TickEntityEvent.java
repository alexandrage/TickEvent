package tick.events;

import org.bukkit.entity.Entity;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class TickEntityEvent extends Event {
	private Entity e;
	private static HandlerList handlers = new HandlerList();

	public TickEntityEvent(Entity e) {
		this.e = e;
	}

	public Entity getEntity() {
		return e;
	}

	public HandlerList getHandlers() {
		return handlers;
	}

	public static HandlerList getHandlerList() {
		return handlers;
	}
}