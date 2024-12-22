package br.com.alura.forumhubalurachallenge.mapper.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record TopicRequest(
	@NotBlank(message = "The topic title must not be null or empty.")
	String title,

	@NotBlank(message = "The message topic must not be null or empty.")
	String message,

	@NotNull(message = "The topic author must not be null.")
	UserRequest author,

	@NotNull(message = "The course topic must not be null.")
	CourseRequest course,

	@NotEmpty(message = "The answers topic must not be empty.")
	List<AnswerRequest> answers
) {
}
