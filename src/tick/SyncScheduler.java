package tick;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.scheduler.BukkitRunnable;

import tick.events.TimeChangeEvent;

public class SyncScheduler extends BukkitRunnable {

	@Override
	public void run() {
		for (World world : Bukkit.getWorlds()) {
			Bukkit.getServer().getPluginManager().callEvent(new TimeChangeEvent(world));
		}
	}
}