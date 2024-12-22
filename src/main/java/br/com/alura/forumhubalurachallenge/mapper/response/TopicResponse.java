package br.com.alura.forumhubalurachallenge.mapper.response;

import br.com.alura.forumhubalurachallenge.enums.TopicStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.List;

public record TopicResponse(
	@NotBlank(message = "The request response topic title cannot be null or empty.")
	@Length(message = "The maximum length of the topic title in response to a request must be a maximum of 50 characters.", max = 50)
	String title,

	@NotBlank(message = "The request response topic message cannot be null or empty.")
	@Length(message = "The maximum length of the topic message in response to a request must be a maximum of 150 characters.", max = 150)
	String message,

	@NotNull(message = "The request response topic create date cannot be null.")
	LocalDateTime createDate,

	@NotNull(message = "The request response topic status cannot be null.")
	TopicStatus status,

	@NotNull(message = "The request response topic author cannot be null.")
	UserResponse author,

	@NotNull(message = "The request response topic course cannot be null.")
	CourseResponse course,

	@NotEmpty(message = "The request response topic answers cannot be empty.")
	List<AnswerResponse> answers
) {
}
