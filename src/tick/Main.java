package tick;

import java.util.Timer;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements ITickEvent {

	private Configs config;
	Timer timer;

	@Override
	public void onEnable() {
		this.getConfig().addDefault("time", false);
		this.getConfig().options().copyDefaults(true);
		this.saveConfig();
		this.config = new Configs(this.getDataFolder().getPath()+"/players/");
		this.timer = new Timer();
		this.timer.schedule(new TickScheduler(this), 0, 1000);
		getServer().getPluginManager().registerEvents(new EventListener(config, this.getConfig()), this);
	}

	@Override
	public void onDisable() {
		this.config.saveAll();
		this.timer.cancel();
	}

	public Long getPlayerTime(Player p) {
		if (this.config.hash(p.getName())) {
			return this.config.get(p.getName()).get().getLong("Time");
		} else {
			return -1l;
		}
	}

	public Long getPlayerTime(String n) {
		if (this.config.hash(n)) {
			return this.config.get(n).get().getLong("Time");
		} else {
			return -1l;
		}
	}
}