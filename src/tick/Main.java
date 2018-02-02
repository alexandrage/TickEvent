package tick;

import java.util.Timer;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	private Configs config;
	Timer timer;

	public Configs config() {
		return config;
	}

	@Override
	public void onEnable() {
		config = new Configs(this.getDataFolder().getPath());
		timer = new Timer();
		timer.schedule(new TickScheduler(this), 0, 1000);
		getServer().getPluginManager().registerEvents(new EventListener(config), this);
	}

	@Override
	public void onDisable() {
		config.saveAll();
		timer.cancel();
	}
}