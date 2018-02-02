package tick;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Configs {
	String folder;

	Configs(String folder) {
		this.folder = folder;
	}

	private Map<String, CustomConfig> sfg = new ConcurrentHashMap<String, CustomConfig>();

	public CustomConfig get(String name) {
		if (sfg.get(name) == null) {
			add(name);
		}
		return sfg.get(name);
	}

	public Map<String, CustomConfig> getConfigs() {
		return sfg;
	}

	public boolean hash(String name) {
		return CustomConfig.exist(name, this.folder);
	}

	public void add(String name) {
		CustomConfig custom = new CustomConfig(name, this.folder);
		sfg.put(name, custom);
	}

	public void save(String name) {
		if (sfg.get(name) == null)
			add(name);
		try {
			sfg.get(name).save();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void saveRem(String name) {
		if (sfg.get(name) == null)
			add(name);
		try {
			sfg.get(name).save();
			sfg.remove(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void saveAll() {
		for (String name : sfg.keySet()) {
			save(name);
		}
	}
}