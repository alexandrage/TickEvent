package tick.events;

import org.bukkit.World;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class TimeChangeEvent extends Event {
	private static HandlerList handlers = new HandlerList();
	World world;

	public TimeChangeEvent(World world) {
		this.world = world;
	}

	public HandlerList getHandlers() {
		return handlers;
	}

	public static HandlerList getHandlerList() {
		return handlers;
	}

	public World getWorld() {
		return this.world;
	}
}
