package br.com.alura.forumhubalurachallenge.mapper.response;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record ProfileResponse(
	@NotBlank(message = "The request response profile name cannot be null or empty.")
	@Length(message = "The profile name of the response to a request must have a maximum of 20 characters.", max = 20)
	String name
) {
}
