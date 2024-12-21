package br.com.alura.forumhubalurachallenge.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_profile")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Profile extends BaseEntity {

	@NotBlank(message = "The profile name cannot be null or empty.")
	@Column(nullable = false, unique = true, length = 20, name = "profile_name")
	private String name;
}
