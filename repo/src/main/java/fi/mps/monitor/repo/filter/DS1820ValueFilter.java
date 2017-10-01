package fi.mps.monitor.repo.filter;

public class DS1820ValueFilter {

	public static String convert(String value) {		
		return value == null ? null : stripValue(value);
	}

	private static String stripValue(String value) {		
		final int pos = value.lastIndexOf("t=") + 2;		
		return value.substring(pos);
	}

}
