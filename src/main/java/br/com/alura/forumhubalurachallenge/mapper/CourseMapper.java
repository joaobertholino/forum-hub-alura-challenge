package br.com.alura.forumhubalurachallenge.mapper;

import br.com.alura.forumhubalurachallenge.mapper.request.CourseRequest;
import br.com.alura.forumhubalurachallenge.mapper.response.CourseResponse;
import br.com.alura.forumhubalurachallenge.model.Course;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CourseMapper {
	CourseResponse entityToResponse(Course course);

	@Mapping(target = "id", ignore = true)
	Course requestToEntity(CourseRequest courseRequest);
}
