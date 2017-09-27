package tick;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import tick.events.TickPlayerEvent;
import tick.events.TickEntityEvent;

public class EventListener implements Listener {
	@EventHandler
	public void onTick(TickPlayerEvent e) {
		CustomConfig time = Main.config().get(e.getPlayer().getName());
		long l = time.get().getInt("Time", 0);
		time.get().set("Time", l + 1);
	}

	@EventHandler
	public void onTick(PlayerQuitEvent e) {
		Configs cfg = Main.config();
		cfg.saverem(e.getPlayer().getName());
	}

	@EventHandler
	public void onTick(TickEntityEvent e) {

	}
}