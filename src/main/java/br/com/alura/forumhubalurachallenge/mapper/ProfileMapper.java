package br.com.alura.forumhubalurachallenge.mapper;

import br.com.alura.forumhubalurachallenge.mapper.request.ProfileRequest;
import br.com.alura.forumhubalurachallenge.mapper.response.ProfileResponse;
import br.com.alura.forumhubalurachallenge.model.Profile;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProfileMapper {
	ProfileResponse entityToResponse(Profile profile);

	@Mapping(target = "id", ignore = true)
	Profile requestToEntity(ProfileRequest profileRequest);
}
