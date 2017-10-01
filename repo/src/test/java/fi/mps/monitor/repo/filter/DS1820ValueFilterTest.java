package fi.mps.monitor.repo.filter;

import static org.junit.Assert.*;

import org.junit.Test;

public class DS1820ValueFilterTest {

	@Test
	public void testConvertValue_AndExpectValue() {
		assertEquals("24250", DS1820ValueFilter.convert("84 01 55 00 7f ff 0c 10 4f : crc=4f YES\n84 01 55 00 7f ff 0c 10 4f t=24250"));
	}
	
	@Test
	public void testConvertNull_AndExpectNull() {
		assertNull(DS1820ValueFilter.convert(null));
	}

}
