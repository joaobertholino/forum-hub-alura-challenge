package br.com.alura.forumhubalurachallenge.mapper;

import br.com.alura.forumhubalurachallenge.mapper.request.TopicRequest;
import br.com.alura.forumhubalurachallenge.mapper.response.TopicResponse;
import br.com.alura.forumhubalurachallenge.model.Topic;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {UserMapper.class, CourseMapper.class, AnswerMapper.class})
public interface TopicMapper {
	TopicResponse entityToResponse(Topic topic);
	List<TopicResponse> entityListToResponseList(List<Topic> topics);

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "createDate", expression = "java(LocalDateTime.now())")
	@Mapping(target = "status", expression = "java(TopicStatus.ACTIVE)")
	Topic requestToEntity(TopicRequest topicRequest);
}
