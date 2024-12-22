package br.com.alura.forumhubalurachallenge.service;

import br.com.alura.forumhubalurachallenge.mapper.request.TopicRequest;
import br.com.alura.forumhubalurachallenge.mapper.response.TopicResponse;
import jakarta.validation.Valid;

import java.util.List;

public interface TopicService {
	List<TopicResponse> findAllTopics();

	TopicResponse saveNewTopic(@Valid TopicRequest topicRequest);
}
