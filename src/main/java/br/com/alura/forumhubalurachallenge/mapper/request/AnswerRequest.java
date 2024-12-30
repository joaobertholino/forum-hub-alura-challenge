package br.com.alura.forumhubalurachallenge.mapper.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record AnswerRequest(
	@NotBlank(message = "The response message cannot be null or empty.")
	String message,

	@NotNull(message = "The response author cannot be null.")
	UserRequest author
) {
}
