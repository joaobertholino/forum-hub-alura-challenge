package br.com.alura.forumhubalurachallenge.service;

import br.com.alura.forumhubalurachallenge.mapper.response.TopicResponse;
import java.util.List;

public interface TopicService {
	List<TopicResponse> findAllTopics();
}
