package fi.mps.monitor.repo;

import java.util.Set;

public interface Repo {

	void put(String id, String value);

	String get(String id);

	Set<String> getIds();

}