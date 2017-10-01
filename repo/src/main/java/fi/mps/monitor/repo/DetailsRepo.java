package fi.mps.monitor.repo;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DetailsRepo implements Repo {

	private final Repo repo;
	private final Map<String, Details> details;

	public DetailsRepo(Repo repo) {
		this.repo = repo;
		this.details = new HashMap<>();
	}

	@Override
	public void put(String id, String value) {
		repo.put(id, value);
	}

	@Override
	public String get(String id) {
		return repo.get(id);
	}

	@Override
	public Set<String> getIds() {
		return repo.getIds();
	}

	public Details getDetails(String id) {
		if (details.containsKey(id)) {
			return details.get(id);
		}
		return new Details(id, "Not registered", "-50", "50");

	}

	public void registerSensor(String id, String title, String label, String min, String max) {
		final Details d = new Details(title, label, min, max);
		details.put(id, d);
	}
}
