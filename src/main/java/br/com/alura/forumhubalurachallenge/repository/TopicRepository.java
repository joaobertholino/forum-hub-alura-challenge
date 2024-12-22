package br.com.alura.forumhubalurachallenge.repository;

import br.com.alura.forumhubalurachallenge.model.Topic;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TopicRepository extends JpaRepository<Topic, UUID> {
	Optional<Topic> findTopicByTitle(@NotBlank(message = "The topic title must not be null or empty.") String title);
	void deleteTopicByTitle(@NotBlank(message = "The topic title must not be null or empty.") String title);
}
