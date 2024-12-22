package br.com.alura.forumhubalurachallenge.mapper;

import br.com.alura.forumhubalurachallenge.mapper.request.AnswerRequest;
import br.com.alura.forumhubalurachallenge.mapper.response.AnswerResponse;
import br.com.alura.forumhubalurachallenge.model.Answer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AnswerMapper {
	AnswerResponse entityToResponse(Answer answer);

	@Mapping(target = "id", ignore = true)
	Answer requestToEntity(AnswerRequest answerRequest);
}
