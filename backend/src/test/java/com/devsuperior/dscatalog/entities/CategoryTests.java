package com.devsuperior.dscatalog.entities;

import org.junit.jupiter.api.Test;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

public class CategoryTests {

	@Test
	public void equalsHashCodeContracts() {
	    EqualsVerifier.forClass(Category.class).suppress(Warning.ALL_FIELDS_SHOULD_BE_USED).verify();
	}
}
