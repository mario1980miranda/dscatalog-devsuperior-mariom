package com.devsuperior.dscatalog.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 5573572785382419086L;

	public ResourceNotFoundException(final String msg) {
		super(msg);
	}
}
