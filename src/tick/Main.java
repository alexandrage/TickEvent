package tick;

import java.util.Timer;

import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener, CommandExecutor {

	private static Main instance;
	private static Configs config;

	public static Main plugin() {
		return instance;
	}

	public static Configs config() {
		return config;
	}

	@Override
	public void onEnable() {
		instance = this;
		config = new Configs();
		Timer timer = new Timer();
		timer.schedule(new TickScheduler(this), 0, 1000);
		getServer().getPluginManager().registerEvents(new EventListener(), this);
	}

	@Override
	public void onDisable() {
		config.saveAll();
	}
}