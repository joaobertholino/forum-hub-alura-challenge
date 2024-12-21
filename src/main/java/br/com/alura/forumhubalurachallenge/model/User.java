package br.com.alura.forumhubalurachallenge.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Entity
@Table(name = "tb_user")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User extends BaseEntity {

	@NotBlank(message = "The user name cannot be null and void.")
	@Column(nullable = false, unique = true, length = 20, name = "user_name")
	private String name;

	@Email(message = "The user's email is invalid.")
	@NotBlank(message = "The user email cannot be null and void.")
	@Column(nullable = false, unique = true, name = "user_email")
	private String email;

	@NotBlank(message = "The user password cannot be null and void.")
	@Length(message = "The password must have at least 50 characters.", min = 50)
	@Column(nullable = false, name = "user_password")
	private String password;

	@NotEmpty(message = "The user profiles list cannot be null and void.")
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(nullable = false, name = "user_profiles")
	private List<Profile> profiles;
}
