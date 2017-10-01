package fi.mps.monitor.repo;

public class Details {

	final String title;
	final String label;
	final String min;
	final String max;

	public Details(String title, String label, String min, String max) {
		this.title = title;
		this.label = label;
		this.min = min;
		this.max = max;
	}

	public String getTitle() {
		return title;
	}

	public String getLabel() {
		return label;
	}

	public String getMin() {
		return min;
	}

	public String getMax() {
		return max;
	}

}
