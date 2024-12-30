package br.com.alura.forumhubalurachallenge.controller;

import br.com.alura.forumhubalurachallenge.mapper.request.TopicRequest;
import br.com.alura.forumhubalurachallenge.mapper.response.TopicResponse;
import br.com.alura.forumhubalurachallenge.service.TopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/topic")
@RequiredArgsConstructor
public class TopicController {
	private final TopicService topicService;

	@GetMapping(value = "/all", produces = "application/json")
	public ResponseEntity<List<TopicResponse>> findAllTopics() {
		return ResponseEntity.status(HttpStatus.OK).body(this.topicService.findAllTopics());
	}

	@PostMapping(value = "/save", produces = "application/json")
	public ResponseEntity<TopicResponse> saveNewTopic(@RequestBody TopicRequest topicRequest) {
		return ResponseEntity.status(HttpStatus.CREATED).body(this.topicService.saveNewTopic(topicRequest));
	}

	@DeleteMapping(value = "/delete", produces = "application/json")
	public ResponseEntity<Void> deleteTopicByTitle(@RequestParam String topicTitle) {
		this.topicService.deleteTopicByTitle(topicTitle);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}
