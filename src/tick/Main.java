package tick;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements ITickEvent {
	private Configs config;
	private EScheduler timer;
	private TScheduler sync;

	public void onEnable() {
		getConfig().addDefault("time", Boolean.valueOf(false));
		getConfig().options().copyDefaults(true);
		saveConfig();
		this.config = new Configs(getDataFolder().getPath() + "/players/");
		this.timer = new EScheduler();
		this.timer.runTaskTimer(this, 0L, 20L);
		getServer().getPluginManager().registerEvents(new EventListener(this.config, getConfig()), this);
		this.sync = new TScheduler();
		this.sync.runTaskTimer(this, 1L, 1L);
	}

	public void onDisable() {
		this.config.saveAll();
		this.timer.cancel();
		this.sync.cancel();
	}

	public Long getPlayerTime(Player p) {
		if (this.config.hash(p.getName())) {
			return Long.valueOf(this.config.get(p.getName()).get().getLong("Time"));
		}
		return Long.valueOf(-1L);
	}

	public Long getPlayerTime(String n) {
		if (this.config.hash(n)) {
			return Long.valueOf(this.config.get(n).get().getLong("Time"));
		}
		return Long.valueOf(-1L);
	}
}
