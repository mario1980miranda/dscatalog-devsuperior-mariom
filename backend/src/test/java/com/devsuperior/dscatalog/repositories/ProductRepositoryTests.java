package com.devsuperior.dscatalog.repositories;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.EmptyResultDataAccessException;

import com.devsuperior.dscatalog.entities.Product;
import com.devsuperior.dscatalog.tests.Factory;

@DataJpaTest
public class ProductRepositoryTests {

	@Autowired
	private ProductRepository repository;

	private Long existingId;
	private Long nonExistingId;
	private Long countTotalProducts;
	
	@BeforeEach
	void setUp() throws Exception {
		this.existingId = 1L;
		this.nonExistingId = 99L;
		this.countTotalProducts = 25L;
	}
	
	@Test
	public void findByIdShouldReturnNonEmptyOptionalOfProductNotNullWhenIdExists() {
		
		final Optional<Product> result = this.repository.findById(this.existingId);
		
		Assertions.assertTrue(result.isPresent());
	}
	
	@Test
	public void findByIdShouldReturnEmpryOptionalOfProductNotNullWhenIdNotExists() {
		
		final Optional<Product> result = this.repository.findById(this.nonExistingId);
		
		Assertions.assertTrue(result.isEmpty());
	}
	
	@Test
	public void saveShouldPersistWithAutoIncrementWhenIdIsNull() {
		Product product = Factory.createProduct();
		product.setId(null);
		
		final Product result = this.repository.save(product);
		
		Assertions.assertNotNull(result.getId());
		Assertions.assertEquals(countTotalProducts + 1, product.getId());
	}
	
	@Test
	public void deleteShouldDeleteObjectWhenIdExists() {
		
		this.repository.deleteById(this.existingId);
		
		final Optional<Product> result = this.repository.findById(1L);
		
		Assertions.assertFalse(result.isPresent());
	}
	
	@Test
	public void deleteShouldThrowEmptyResultDataAccessExceptionWhenIdDoesNotExists() {
		
		Assertions.assertThrows(EmptyResultDataAccessException.class, () -> {
			
			repository.deleteById(this.nonExistingId);
		});
	}
}
