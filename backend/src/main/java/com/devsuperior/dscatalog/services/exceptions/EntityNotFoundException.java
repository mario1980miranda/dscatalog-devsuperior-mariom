package com.devsuperior.dscatalog.services.exceptions;

public class EntityNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 5573572785382419086L;

	public EntityNotFoundException(final String msg) {
		super(msg);
	}
}
