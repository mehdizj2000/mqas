package au.com.mqas.logic.business.mapper;

import java.util.List;
import java.util.Set;

import org.mapstruct.Mapper;

import au.com.mqas.db.data.model.AccessKey;
import au.com.mqas.transfer.data.dto.AccessKeyDto;

@Mapper(componentModel = "spring")
public interface AccessKeyMapper {

	AccessKeyDto accessKeyToAccessKeyDto(AccessKey accessKey);

	AccessKey accessKeyDtoToAccessKey(AccessKeyDto accessKeyDto);

	Set<AccessKeyDto> accessKeysToAccessKeyDtosSet(Set<AccessKey> accessKey);

	List<AccessKeyDto> accessKeysToAccessKeyDtosList(List<AccessKey> accessKey);

}
