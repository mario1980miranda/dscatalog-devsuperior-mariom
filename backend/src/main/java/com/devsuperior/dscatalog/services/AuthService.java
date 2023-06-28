package com.devsuperior.dscatalog.services;

import org.springframework.stereotype.Service;

import com.devsuperior.dscatalog.dto.EmailDTO;

import jakarta.validation.Valid;

@Service
public class AuthService {

	public void createRecoverToken(@Valid EmailDTO body) {
		
	}

}
