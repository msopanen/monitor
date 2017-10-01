package fi.mps.monitor.repo;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashSet;

import org.junit.Test;

public class MapRepoTest {

	final Repo repo = new MapRepo();

	@Test(expected = NullPointerException.class)
	public void testSetWithNullId_AndExpectNullPointerException() {
		repo.put(null, "123");
	}

	@Test(expected = NullPointerException.class)
	public void testSetNullValue_AndExpectNullPointerException() {
		repo.put("A1234", null);
	}
	
	@Test(expected = NullPointerException.class)
	public void testGetWithNullId_AndExpectNullPointerException() {
		repo.get(null);
	}
	
	@Test
	public void testSetAndGetValue_AndExpectValueToBeFound() {
		repo.put("A1234", "20");
		assertEquals("20", repo.get("A1234"));
	}
	
	@Test
	public void testGetKeys_AndExpectKeysToBeFound() {
		repo.put("A1234", "20");
		repo.put("B1234", "21");
		assertEquals(new HashSet<String>(Arrays.asList("A1234","B1234")), repo.getIds());
	}

}
