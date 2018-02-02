package tick;

import java.util.Timer;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements ITickEvent {

	private Configs config;
	Timer timer;

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
	
	public Long getPlayerTime(Player p) {
		return this.config.get(p.getName()).get().getLong("Time");
	}
	
	public Long getPlayerTime(String n) {
		return this.config.get(n).get().getLong("Time");
	}
}