package tick;

import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener, CommandExecutor {

	@Override
	public void onEnable() {
		new TickScheduler(this).runTaskTimerAsynchronously(this, 0, 1);
		getServer().getPluginManager().registerEvents(new EventListener(this), this);
	}
}
