package com.devsuperior.dscatalog.resources.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {

	private static final long serialVersionUID = 8832100158876522238L;
	
	private List<FieldMessage> errors = new ArrayList<>();

	public List<FieldMessage> getErrors() {
		return errors;
	}

	public void addError(final String fieldName, final String message) {
		errors.add(new FieldMessage(fieldName, message));
	}
}
