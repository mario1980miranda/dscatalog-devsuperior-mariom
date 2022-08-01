package com.devsuperior.dscatalog.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dscatalog.dto.RoleDTO;
import com.devsuperior.dscatalog.entities.Role;
import com.devsuperior.dscatalog.repositories.RoleRepository;
import com.devsuperior.dscatalog.services.exceptions.DatabaseException;
import com.devsuperior.dscatalog.services.exceptions.ResourceNotFoundException;

@Service
public class RoleService {

	@Autowired
	private RoleRepository repository;

	@Transactional(readOnly = true)
	public RoleDTO findById(final Long id) {
		final Optional<Role> obj = this.repository.findById(id);
		final Role entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new RoleDTO(entity);
	}

	@Transactional
	public RoleDTO insert(final RoleDTO dto) {
		Role entity = new Role();
		this.copyDtoToEntity(dto, entity);
		entity = this.repository.save(entity);
		return new RoleDTO(entity);
	}

	@Transactional
	public RoleDTO update(final Long id, final RoleDTO dto) {
		try {
			Role entity = this.repository.getOne(id);
			this.copyDtoToEntity(dto, entity);
			entity = this.repository.save(entity);
			return new RoleDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found : " + id);
		}
	}

	public void delete(final Long id) {
		try {
			this.repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found : " + id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity violation");
		}
	}
	
	private void copyDtoToEntity(RoleDTO dto, Role entity) {
		entity.setAuthority(dto.getAuthority());
	}
}
