package br.com.alura.forumhubalurachallenge.mapper.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

import java.util.List;

public record UserRequest(
	@NotBlank(message = "The user name cannot be null and void.")
	String name,

	@Email(message = "The user's email is invalid.")
	@NotBlank(message = "The user email cannot be null and void.")
	String email,

	@NotBlank(message = "The user password cannot be null and void.")
	@Length(message = "The password must have at least 50 characters.", min = 50)
	String password,

	@NotEmpty(message = "The user profiles list cannot be null and void.")
	List<ProfileRequest> profiles
) {
}
