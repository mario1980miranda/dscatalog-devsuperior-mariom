package com.devsuperior.dscatalog.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class EmailDTO {

	@NotBlank(message = "Champs requis")
	@Email(message = "Entrez un email valide")
	private String email;

	public EmailDTO() {

	}

	public EmailDTO(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

}
