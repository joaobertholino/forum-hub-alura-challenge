package br.com.alura.forumhubalurachallenge.mapper.response;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

import java.util.List;

public record UserResponse(
	@NotBlank(message = "The user name in the response to a request cannot be null or empty.")
	@Length(message = "The user name in the response to a request must have a maximum of 20 characters.", max = 20)
	String name,

	@Email(message = "The user's email reply to a request is invalid.")
	@NotBlank(message = "The email in the response to a request cannot be null or empty.")
	String email,

	@NotEmpty(message = "The profiles in the response to a request cannot be empty.")
	List<ProfileResponse> profiles
	) {
}
