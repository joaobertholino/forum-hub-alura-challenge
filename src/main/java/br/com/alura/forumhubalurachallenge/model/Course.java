package br.com.alura.forumhubalurachallenge.model;

import br.com.alura.forumhubalurachallenge.enums.CourseCategory;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_course")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Course extends BaseEntity {

	@NotBlank(message = "The course name cannot be null or empty.")
	@Column(nullable = false, unique = true, length = 20, name = "course_name")
	private String name;

	@NotNull(message = "The course category cannot be null.")
	@Column(nullable = false, name = "course_category")
	private CourseCategory courseCategory;
}
