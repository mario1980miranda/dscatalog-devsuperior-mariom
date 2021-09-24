package com.devsuperior.dscatalog.tests;

import java.time.Instant;

import com.devsuperior.dscatalog.dto.ProductDTO;
import com.devsuperior.dscatalog.entities.Category;
import com.devsuperior.dscatalog.entities.Product;

public class Factory {

	public static Product createProduct() {
		Product product = new Product(
				1L, 
				"The Lord of the Rings", 
				"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", 
				90.5, 
				"https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/1-big.jpg", 
				Instant.parse("2020-07-13T20:50:07.12345Z"));
		product.getCategories().add(new Category(2L, "Electronics"));
		return product;
	}
	
	public static ProductDTO createProductDTO() {
		Product product = Factory.createProduct();
		return new ProductDTO(product, product.getCategories());
	}
}
