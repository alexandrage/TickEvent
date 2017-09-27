package tick.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class TickPayerEvent extends Event {
	private Player p;
	private static HandlerList handlers = new HandlerList();

	public TickPayerEvent(Player p) {
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