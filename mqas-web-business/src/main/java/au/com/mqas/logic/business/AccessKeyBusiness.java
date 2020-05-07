package au.com.mqas.logic.business;

import java.util.List;

import au.com.mqas.transfer.data.dto.AccessKeyDto;
import au.com.mqas.transfer.data.dto.AccessLevelDto;

public interface AccessKeyBusiness {

	List<AccessKeyDto> listUserKeysByEmail(String email);

	List<AccessLevelDto> listAccessLevelDtos();

	AccessLevelDto getAccessLevelDtoById(Long id);

	void generateAPIKey(String username, Long prodId);

}
