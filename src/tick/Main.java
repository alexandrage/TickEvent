package tick;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements ITickEvent {

	private Configs config;
	private TickScheduler timer;
	private SyncScheduler sync;

	@Override
	public void onEnable() {
		this.getConfig().addDefault("time", false);
		this.getConfig().options().copyDefaults(true);
		this.saveConfig();
		this.config = new Configs(this.getDataFolder().getPath() + "/players/");
		timer = new TickScheduler();
		timer.runTaskTimer(this, 0, 20);
		getServer().getPluginManager().registerEvents(new EventListener(config, this.getConfig()), this);
		sync = new SyncScheduler();
		sync.runTaskTimer(this, 1, 1);
	}

	@Override
	public void onDisable() {
		this.config.saveAll();
		this.timer.cancel();
		this.sync.cancel();
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