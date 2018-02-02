package tick;

import org.bukkit.entity.Player;

public interface ITickEvent {
	public Long getPlayerTime(Player p);
	public Long getPlayerTime(String p);
}