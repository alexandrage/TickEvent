package tick.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class TickEvent extends Event {
	private Player p;
	private static final HandlerList handlers = new HandlerList();

	public TickEvent(Player p) {
		this.p = p;
	}

	public Player getPlayer() {
		return p;
	}

	public HandlerList getHandlers() {
		return handlers;
	}

	public static HandlerList getHandlerList() {
		return handlers;
	}
}