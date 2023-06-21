package com.devsuperior.dscatalog.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dscatalog.dto.CategoryDTO;
import com.devsuperior.dscatalog.dto.ProductDTO;
import com.devsuperior.dscatalog.entities.Category;
import com.devsuperior.dscatalog.entities.Product;
import com.devsuperior.dscatalog.repositories.CategoryRepository;
import com.devsuperior.dscatalog.repositories.ProductRepository;
import com.devsuperior.dscatalog.services.exceptions.DatabaseException;
import com.devsuperior.dscatalog.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Transactional(readOnly = true)
	public Page<ProductDTO> findAllPaged(Long categoryId, String name, final Pageable pageable) {
		List<Category> categories = (categoryId <= 0) ? null : Arrays.asList(categoryRepository.getOne(categoryId));
		final Page<Product> page = this.repository.find(categories, name, pageable);
		repository.findProductsWithCategories(page.getContent());
		return page.map(x -> new ProductDTO(x, x.getCategories()));
	}

	@Transactional(readOnly = true)
	public ProductDTO findById(final Long id) {
		final Optional<Product> obj = this.repository.findById(id);
		final Product entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new ProductDTO(entity, entity.getCategories());
	}

	@Transactional
	public ProductDTO insert(final ProductDTO dto) {
		Product entity = new Product();
		this.copyDtoToEntity(dto, entity);
		entity = this.repository.save(entity);
		return new ProductDTO(entity);
	}

	@Transactional
	public ProductDTO update(final Long id, final ProductDTO dto) {
		try {
			Product entity = this.repository.getOne(id);
			this.copyDtoToEntity(dto, entity);
			entity = this.repository.save(entity);
			return new ProductDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found : " + id);
		}
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public void delete(final Long id) {
		try {
			this.repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found : " + id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity violation");
		}
	}
	
	private void copyDtoToEntity(final ProductDTO dto, final Product entity) {
		entity.setName(dto.getName());
		entity.setDescription(dto.getDescription());
		entity.setDate(dto.getDate());
		entity.setImgUrl(dto.getImgUrl());
		entity.setPrice(dto.getPrice());
		
		entity.getCategories().clear();
		
		for (CategoryDTO catDto : dto.getCategories()) {
			Category category = this.categoryRepository.getOne(catDto.getId());
			entity.getCategories().add(category);
		}
	}
}
