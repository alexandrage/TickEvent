package tick;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import tick.events.TickPlayerEvent;

public class EventListener implements Listener {
	Configs config;
	FileConfiguration c;

	EventListener(Configs config, FileConfiguration c) {
		this.config = config;
		this.c = c;
	}

	public static String ticksToDate(long ticks) {
		ticks = ticks - 18000L + 24000L;
		long days = ticks / 24000L;
		ticks -= days * 24000L;
		long hours = ticks / 1000L;
		ticks -= hours * 1000L;
		long minutes = (long) Math.floor(ticks / 16.666666666666668D);
		double dticks = ticks - minutes * 16.666666666666668D;
		long seconds = (long) Math.floor(dticks / 0.2777777777777778D);
		Calendar cal = Calendar.getInstance(TimeZone.getDefault(), Locale.ENGLISH);
		cal.setLenient(true);
		cal.set(0, 0, 1, 0, 0, 0);
		cal.add(6, (int) days);
		cal.add(11, (int) hours);
		cal.add(12, (int) minutes);
		cal.add(13, (int) seconds + 1);
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm", Locale.ENGLISH);
		return sdf.format(cal.getTime());
	}

	@EventHandler
	public void onTick(TickPlayerEvent e) {
		if (this.c.getBoolean("time")) {
			CustomConfig time = this.config.get(e.getPlayer().getName());
			long l = time.get().getLong("Time", 0L);
			time.get().set("Time", Long.valueOf(l + 1L));
		}
	}

	@EventHandler
	public void onTick(PlayerQuitEvent e) {
		this.config.saveRem(e.getPlayer().getName());
	}
}
