package tick;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import tick.events.TickPlayerEvent;
import tick.events.TimeChangeEvent;
import tick.events.TickEntityEvent;

public class EventListener implements Listener {
	Configs config;
	FileConfiguration c;

	EventListener(Configs config, FileConfiguration c) {
		this.config = config;
		this.c = c;
	}

	@EventHandler
	public void onTick(TimeChangeEvent e) {
		e.getWorld().getTime();
		e.getWorld();
	}

	@EventHandler
	public void onTick(TickPlayerEvent e) {
		if (c.getBoolean("time")) {
			CustomConfig time = this.config.get(e.getPlayer().getName());
			long l = time.get().getLong("Time", 0);
			time.get().set("Time", l + 1);
		}
	}

	@EventHandler
	public void onTick(PlayerQuitEvent e) {
		this.config.saveRem(e.getPlayer().getName());
	}

	@EventHandler
	public void onTick(TickEntityEvent e) {

	}
}