package tick;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import tick.events.TickEvent;

public class TickScheduler extends BukkitRunnable {
	Main plugin;

	TickScheduler(Main plugin) {
		this.plugin = plugin;
	}

	@Override
	public void run() {
		for (Player p : Bukkit.getOnlinePlayers()) {
			this.plugin.getServer().getPluginManager().callEvent(new TickEvent(p));
		}
	}
}