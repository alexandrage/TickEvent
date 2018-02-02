package tick;

import java.util.TimerTask;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import tick.events.TickPlayerEvent;
import tick.events.TickEntityEvent;

public class TickScheduler extends TimerTask {
	Main plugin;

	TickScheduler(Main plugin) {
		this.plugin = plugin;
	}

	@Override
	public void run() {
		for (Player p : Bukkit.getOnlinePlayers()) {
			this.plugin.getServer().getPluginManager().callEvent(new TickPlayerEvent(p));
		}
		for (World world : Bukkit.getWorlds()) {
			for (Entity e : world.getEntities()) {
				this.plugin.getServer().getPluginManager().callEvent(new TickEntityEvent(e));
			}
		}
	}
}