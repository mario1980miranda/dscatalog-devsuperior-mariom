package com.devsuperior.dscatalog.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dscatalog.dto.EmailDTO;
import com.devsuperior.dscatalog.dto.NewPasswordDTO;
import com.devsuperior.dscatalog.services.AuthService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/auth")
public class AuthResource {

	@Autowired
	private AuthService service;

	@PostMapping("/recover-token")
	public ResponseEntity<Void> createRecoverToken(@Valid @RequestBody EmailDTO body) {
		this.service.createRecoverToken(body);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/new-password")
	public ResponseEntity<Void> saveNewPassword(@Valid @RequestBody NewPasswordDTO body) {
		this.service.saveNewPassword(body);
		return ResponseEntity.noContent().build();
	}
	
}
