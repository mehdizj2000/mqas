package au.com.mqas.logic.business.mapper;

import java.util.List;
import java.util.Set;

import org.mapstruct.Mapper;

import au.com.mqas.db.data.model.AccessLevel;
import au.com.mqas.transfer.data.dto.AccessLevelDto;

@Mapper(componentModel = "spring")
public interface AccessLevelMapper {

	AccessLevelDto accessLevelToAccessLevelDto(AccessLevel accessLevel);

	AccessLevel accessLevelDtoToAccessLevel(AccessLevelDto accessLevelDto);

	List<AccessLevelDto> accessLevelsToAccessLevelDtosList(List<AccessLevel> accessLevels);

	Set<AccessLevelDto> accessLevelsToAccessLevelDtosSet(Set<AccessLevel> accessLevels);

}
