package com.devsuperior.dscatalog.repositories;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.devsuperior.dscatalog.entities.Category;
import com.devsuperior.dscatalog.tests.Factory;

@DataJpaTest
public class CategoryRepositoryTests {

	@Autowired
	private CategoryRepository repository;
	
	private long existingId;
	private long nonExistingId;
	private int countTotalCategories;
	
	@BeforeEach
	void setUp() {
		existingId = 1L;
		nonExistingId = 1000L;
		countTotalCategories = 3;
	}
	
	@Test
	public void findAllShouldReturnListOfCategory() {
		final List<Category> result = repository.findAll();
		
		Assertions.assertTrue(result != null && result.size() > 0);
	}
	
	@Test
	public void findAllShouldReturnPageOfCategory() {
		final Pageable pageable = PageRequest.of(0, 10);
		
		final Page<Category> result = repository.findAll(pageable);
		
		Assertions.assertNotNull(result);
		Assertions.assertNotNull(result.get());
	}
	
	@Test
	public void findByIdShouldReturnOptionalOfCategoryWhenIdExists() {
		final Optional<Category> result = repository.findById(existingId);
		
		Assertions.assertTrue(result.isPresent());
	}
	
	@Test
	public void findByIdShouldReturnEmptyOptionalOfCategoryWhenIdDoesNotExist() {
		final Optional<Category> result = repository.findById(nonExistingId);
		
		Assertions.assertTrue(result.isEmpty());
	}
	
	@Test
	public void saveShouldPersistWithAutoIncrementWhenIdIsNull() {
		Category category = Factory.createCategory();
		category.setId(null);
		
		final Category result = repository.save(category);
		
		Assertions.assertNotNull(result);
		Assertions.assertNotNull(result.getId());
		Assertions.assertEquals(countTotalCategories + 1, category.getId());
	}
	
	@Test
	public void deleteShouldDeleteObjectWhenIdExists() {
		repository.deleteById(existingId);
		
		final Optional<Category> result = repository.findById(existingId);
		
		Assertions.assertFalse(result.isPresent());
	}
	
	@Test
	public void deleteShouldThrowEmptyResultDataAccessExceptionWhenIdDoesNotExist() {
		Assertions.assertThrows(EmptyResultDataAccessException.class, () -> {
			repository.deleteById(nonExistingId);
		});
	}
}
