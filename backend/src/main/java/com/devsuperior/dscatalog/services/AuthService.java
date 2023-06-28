package com.devsuperior.dscatalog.services;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.devsuperior.dscatalog.dto.EmailDTO;
import com.devsuperior.dscatalog.dto.NewPasswordDTO;
import com.devsuperior.dscatalog.entities.PasswordRecover;
import com.devsuperior.dscatalog.entities.User;
import com.devsuperior.dscatalog.repositories.PasswordRecoverRepository;
import com.devsuperior.dscatalog.repositories.UserRepository;
import com.devsuperior.dscatalog.services.exceptions.ResourceNotFoundException;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Service
public class AuthService {

	@Value("${email.password-recover.token.minutes}")
	private Long tokenMinutes;
	@Value("${email.password-recover.uri}")
	private String recoverUri;

	private UserRepository userRepository;
	private PasswordRecoverRepository passwordRecoverRepository;
	private EmailService emailService;
	private PasswordEncoder passwordEncoder;



	public AuthService(UserRepository userRepository, PasswordRecoverRepository passwordRecoverRepository,
			EmailService emailService, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordRecoverRepository = passwordRecoverRepository;
		this.emailService = emailService;
		this.passwordEncoder = passwordEncoder;
	}

	@Transactional
	public void createRecoverToken(@Valid EmailDTO body) {
		final User user = this.userRepository.findByEmail(body.getEmail());

		if (user == null) {
			throw new ResourceNotFoundException("Email non trouvé");
		}

		final String token = UUID.randomUUID().toString();
		
		PasswordRecover entity = new PasswordRecover();
		entity.setEmail(body.getEmail());
		entity.setToken(token);
		entity.setExpiration(Instant.now().plusSeconds(tokenMinutes * 60L));

		entity = this.passwordRecoverRepository.save(entity);

		String messageBody = "Acesse o link para definir uma nova senha:\n\n" + recoverUri + token + "\n\nLink valido por " + tokenMinutes + "minutos.";
		
		this.emailService.sendEmail(body.getEmail(), "Password Recover", messageBody);
	}

	@Transactional
	public void saveNewPassword(@Valid NewPasswordDTO body) {
		final List<PasswordRecover> result = this.passwordRecoverRepository.searchValidTokens(body.getToken(), Instant.now());
		
		if (result.size() == 0) {
			throw new ResourceNotFoundException("Jeton non trouvé");
		}
		
		User user = this.userRepository.findByEmail(result.get(0).getEmail());
		user.setPassword(this.passwordEncoder.encode(body.getPassword()));
		this.userRepository.save(user);
	}

}
