package com.devsuperior.dscatalog.dto;

import java.io.Serializable;

import com.devsuperior.dscatalog.entities.Category;

public class CategoryDTO implements Serializable {

	private static final long serialVersionUID = 2921442259335847483L;
	
	private Long id;
	private String name;
	
	public CategoryDTO() {
		
	}

	public CategoryDTO(final Long id, final String name) {
		this.id = id;
		this.name = name;
	}
	
	public CategoryDTO(final Category entity) {
		this.id = entity.getId();
		this.name = entity.getName();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
