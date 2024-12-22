package br.com.alura.forumhubalurachallenge.mapper;

import br.com.alura.forumhubalurachallenge.mapper.request.UserRequest;
import br.com.alura.forumhubalurachallenge.mapper.response.UserResponse;
import br.com.alura.forumhubalurachallenge.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = ProfileMapper.class)
public interface UserMapper {
	UserResponse entityToResponse(User user);

	@Mapping(target = "id", ignore = true)
	User requestToEntity(UserRequest userRequest);
}
