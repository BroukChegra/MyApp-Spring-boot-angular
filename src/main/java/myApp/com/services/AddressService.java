package myApp.com.services;

import java.util.List;

import myApp.com.shared.dto.AddressDto;

public interface AddressService {
	
	List<AddressDto> getAllAddresses(String email);
	
	AddressDto createAddress(AddressDto address,String email);
	
	AddressDto getAddress(String addressId);

	
	AddressDto updateAddress(String addressId, AddressDto addressDto);
	
	void deleteAddress(String addressId);
	

}
