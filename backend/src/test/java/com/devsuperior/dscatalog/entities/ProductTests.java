package com.devsuperior.dscatalog.entities;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

@ExtendWith(SpringExtension.class)
public class ProductTests {

	@Test
	public void equalsHashCodeContracts() {
	    EqualsVerifier.forClass(Product.class)
	    	.withPrefabValues(Category.class, new Category(1L, "A"), new Category(2L, "B"))
	    	.suppress(Warning.ALL_FIELDS_SHOULD_BE_USED)
	    	.verify();
	}
}
