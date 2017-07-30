package tick;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import tick.events.TickEvent;
public class EventListener implements Listener {
	Main plugin;

	EventListener(Main plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onTick(TickEvent e) {
		Player p = e.getPlayer();
		if (p.getRemainingAir() < 290) {
			//TODO
		}
	}
}