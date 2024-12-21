package br.com.alura.forumhubalurachallenge.model;

import br.com.alura.forumhubalurachallenge.enums.TopicStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "tb_topic")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Topic extends BaseEntity {

	@NotBlank(message = "The topic title must not be null or empty.")
	@Column(nullable = false, unique = true, length = 50, name = "topic_title")
	private String title;

	@NotBlank(message = "The message topic must not be null or empty.")
	@Column(nullable = false, length = 150, name = "topic_message")
	private String message;

	@NotNull(message = "The create date topic must not be null.")
	@Column(nullable = false, name = "topic_create_date")
	private LocalDateTime createDate;

	@NotNull(message = "The status topic must not be null.")
	@Column(nullable = false, name = "topic_status")
	@Enumerated(EnumType.STRING)
	private TopicStatus status;

	@NotNull(message = "The topic author must not be null.")
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH}, optional = false)
	@JoinColumn(nullable = false, name = "topic_author")
	private User author;

	@NotNull(message = "The course topic must not be null.")
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH}, optional = false)
	@JoinColumn(nullable = false, name = "topic_course")
	private Course course;

	@NotEmpty(message = "The answers topic must not be empty.")
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REFRESH}, mappedBy = "topic")
	@JoinColumn(nullable = false, name = "topic_answers")
	private List<Answer> answers;
}
