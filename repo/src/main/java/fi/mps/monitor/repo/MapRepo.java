package fi.mps.monitor.repo;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class MapRepo implements Repo {

	private final Map<String,String> valuesById = new ConcurrentHashMap<>();
	
	@Override
	public void put(String id, String value) {
		valuesById.put(id, value);
	}

	@Override
	public String get(String id) {
		return valuesById.get(id);
	}

	@Override
	public Set<String> getIds() {
		return valuesById.keySet();
	}

}
