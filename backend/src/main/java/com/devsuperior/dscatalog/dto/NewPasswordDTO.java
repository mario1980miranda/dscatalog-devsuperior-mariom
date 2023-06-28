package com.devsuperior.dscatalog.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class NewPasswordDTO {

	@NotBlank(message = "Champs requis")
	private String token;
	@NotBlank(message = "Champs requis")
	@Size(min = 8, message = "Le champ doit avoir au moins 8 caractères")
	private String password;

	public NewPasswordDTO() {

	}

	public NewPasswordDTO(String token, String password) {
		this.token = token;
		this.password = password;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
