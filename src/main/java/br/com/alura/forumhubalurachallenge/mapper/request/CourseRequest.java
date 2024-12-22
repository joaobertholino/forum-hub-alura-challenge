package br.com.alura.forumhubalurachallenge.mapper.request;

import br.com.alura.forumhubalurachallenge.enums.CourseCategory;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CourseRequest(
	@NotBlank(message = "The course name cannot be null or empty.")
	String name,

	@NotNull(message = "The course category cannot be null.")
	CourseCategory courseCategory
) {
}
