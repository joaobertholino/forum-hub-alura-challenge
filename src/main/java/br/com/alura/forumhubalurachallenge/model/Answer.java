package br.com.alura.forumhubalurachallenge.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_answers")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Answer extends BaseEntity {

	@NotBlank(message = "The response message cannot be null or empty.")
	@Column(nullable = false, length = 150, name = "answer_message")
	private String message;

	@NotNull(message = "The response topic cannot be null.")
	@ManyToOne(optional = false)
	@JoinColumn(nullable = false, name = "answer_topic")
	private Topic topic;

	@NotNull(message = "The response create date cannot be null.")
	@Column(nullable = false, name = "answer_create_date")
	private LocalDateTime createDate;

	@NotNull(message = "The response author cannot be null.")
	@ManyToOne(optional = false)
	@JoinColumn(nullable = false, name = "answer_author")
	private User author;
}
