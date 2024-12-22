package br.com.alura.forumhubalurachallenge.mapper.request;

import jakarta.validation.constraints.NotBlank;

public record ProfileRequest(
	@NotBlank(message = "The profile name cannot be null or empty.")
	String name
) {
}
