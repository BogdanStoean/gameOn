package ro.gameon.util;

import java.util.List;

public class DataTableResult<T> extends AJAXResponse {

	public long totalRecords;

	public List<T> records;

	private DataTableResult() {
		super(null, null);
	}

	public DataTableResult(String status, String message, List<T> results,
			long totalRecords) {
		super(status, message);

		this.records = results;
		this.totalRecords = totalRecords;
	}

	public DataTableResult(List<T> results) {
		super("success", "ok");

		this.records = results;
		this.totalRecords = results.size();
	}

	public DataTableResult(List<T> results, Long totalRecords) {
		super("success", "ok");

		this.records = results;
		this.totalRecords = totalRecords;
	}

	@Override
	public String toString() {
		return "DataTableResult [totalRecords=" + totalRecords + ", records=" + records + "]";
	}

}
