package br.com.alura.forumhubalurachallenge.mapper.response;

import br.com.alura.forumhubalurachallenge.enums.CourseCategory;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public record CourseResponse(
	@NotBlank(message = "The course name of the response to a request must not be null or empty.")
	@Length(message = "The course name of a request response must have a maximum of 20 characters.", max = 20)
	String name,

	@NotNull(message = "The course category of the response to a request must not be null.")
	CourseCategory courseCategory
) {
}
