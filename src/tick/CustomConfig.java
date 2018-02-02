package tick;

import java.io.File;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class CustomConfig {

	private YamlConfiguration yml;
	private File file;
	String folder;

	CustomConfig(String name, String folder) {
		this.folder = folder;
		this.file = new File(folder, name + ".yml");
		this.file.getParentFile().mkdirs();
		yml = YamlConfiguration.loadConfiguration(file);
		this.file.getParentFile().mkdirs();
	}

	public FileConfiguration get() {
		return yml;
	}

	public void save() {
		try {
			yml.save(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void reload() {
		try {
			yml.load(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static boolean exist(String name, String f) {
		File file = new File(f, name + ".yml");
		return file.exists();
	}
}