package br.com.alura.forumhubalurachallenge.service.implementation;

import br.com.alura.forumhubalurachallenge.mapper.TopicMapper;
import br.com.alura.forumhubalurachallenge.mapper.request.TopicRequest;
import br.com.alura.forumhubalurachallenge.mapper.response.TopicResponse;
import br.com.alura.forumhubalurachallenge.model.Topic;
import br.com.alura.forumhubalurachallenge.repository.TopicRepository;
import br.com.alura.forumhubalurachallenge.service.TopicService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TopicServiceImpl implements TopicService {
	private final TopicRepository topicRepository;
	private final TopicMapper topicMapper;

	@Override
	@Cacheable(value = "find-all-cache")
	public List<TopicResponse> findAllTopics() {
		List<Topic> topics = this.topicRepository.findAll();
		return this.topicMapper.entityListToResponseList(topics);
	}

	@Override
	@Transactional
	public TopicResponse saveNewTopic(TopicRequest topicRequest) {
		Topic topicSaved = this.topicRepository.save(this.topicMapper.requestToEntity(topicRequest));
		return this.topicMapper.entityToResponse(topicSaved);
	}
}
