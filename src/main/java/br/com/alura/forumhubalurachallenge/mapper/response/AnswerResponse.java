package br.com.alura.forumhubalurachallenge.mapper.response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

public record AnswerResponse(
	@NotBlank(message = "The response message of a response to a request must not be null or empty.")
	@Length(message = "A mensagem de resposta de uma resposta a uma requisição deve ter no maximo 150 caracteres.", max = 150)
	String message,

	@NotNull(message = "The response create date of a response to a request must not be null.")
	LocalDateTime createDate
) {
}
