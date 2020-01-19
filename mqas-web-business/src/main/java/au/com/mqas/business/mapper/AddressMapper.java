package au.com.mqas.business.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import au.com.mqas.domain.model.Address;
import au.com.mqas.transfer.data.dto.AddressDto;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    AddressDto addressToAddressDto(Address address);
    
    Address adddressDtoToAddress(Address address);
    
    List<AddressDto> addressesToAddressDtos(List<Address> address);
}
