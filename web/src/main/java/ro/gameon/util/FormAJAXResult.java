package ro.gameon.util;

import java.util.Map;

public class FormAJAXResult<T> {

	private final Boolean success;

	final Map<String, String> errors;

	final T formBean;

	public FormAJAXResult(Map<String, String> errors) {
		this.success = false;
		this.errors = errors;
		this.formBean = null;
	}

	public FormAJAXResult(T formBean) {
		this.success = true;
		this.errors = null;
		this.formBean = formBean;
	}

	public Boolean getSuccess() {
		return success;
	}

	public Map<String, String> getErrors() {
		return errors;
	}

	public T getFormBean() {
		return formBean;
	}

	@Override
	public String toString() {
		return "FormAJAXResult [success=" + success + ", formBean=" + formBean + ", errors=" + errors + "]";
	}
}
