package tick;

import java.util.Iterator;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import tick.events.TickPlayerEvent;
import tick.events.TickEntityEvent;

public class TickScheduler extends BukkitRunnable {

	@Override
	public void run() {
		Iterator<? extends Player> itp = Bukkit.getOnlinePlayers().iterator();
		while (itp.hasNext()) {
			Bukkit.getServer().getPluginManager().callEvent(new TickPlayerEvent(itp.next()));
		}

		for (World world : Bukkit.getWorlds()) {
			Iterator<Entity> ite = world.getEntities().iterator();
			while (ite.hasNext()) {
				Bukkit.getServer().getPluginManager().callEvent(new TickEntityEvent(ite.next()));
			}
		}
	}
}