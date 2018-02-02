package tick;

import java.util.HashMap;
import java.util.Map;

public class Configs {
	String folder;

	Configs(String folder) {
		this.folder = folder;
	}

	private Map<String, CustomConfig> sfg = new HashMap<String, CustomConfig>();

	public CustomConfig get(String name) {
		synchronized (this) {
			if (sfg.get(name) == null) {
				add(name);
			}
			return sfg.get(name);
		}
	}

	public Map<String, CustomConfig> getConfigs() {
		return sfg;
	}

	public void add(String name) {
		synchronized (this) {
			CustomConfig custom = new CustomConfig(name, this.folder);
			sfg.put(name, custom);
		}
	}

	public void save(String name) {
		synchronized (this) {
			if (sfg.get(name) == null)
				add(name);
			try {
				sfg.get(name).save();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void saveRem(String name) {
		synchronized (this) {
			if (sfg.get(name) == null)
				add(name);
			try {
				sfg.get(name).save();
				sfg.remove(name);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void saveAll() {
		synchronized (this) {
			for (String name : sfg.keySet()) {
				save(name);
			}
		}
	}
}