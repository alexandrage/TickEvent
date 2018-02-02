# TickEvent

Использование ивентов.
import tick.events.TickPlayerEvent;
import tick.events.TickEntityEvent;

	@EventHandler
	public void onTick(TickPlayerEvent e) {
		
	}
	@EventHandler
	public void onTick(TickEntityEvent e) {
		
	}

Подключение интерфейса для получения времени игрока в игре.

import tick.ITickEvent;

public ITickEvent tick;

	@Override
	public void onEnable() {
		tick = (ITickEvent) getServer().getPluginManager().getPlugin("TickEvent");
	}

this.plugin.tick.getPlayerTime(player);

this.plugin.tick.getPlayerTime(playername);

