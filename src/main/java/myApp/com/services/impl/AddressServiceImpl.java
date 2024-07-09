package myApp.com.services.impl;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import myApp.com.entities.AddressEntity;
import myApp.com.entities.UserEntity;
import myApp.com.repositories.AddressRepository;
import myApp.com.repositories.UserRepository;
import myApp.com.services.AddressService;
import myApp.com.shared.Utils;
import myApp.com.shared.dto.AddressDto;
import myApp.com.shared.dto.UserDto;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	AddressRepository addressRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	Utils util;
	
	@Override
	public List<AddressDto> getAllAddresses(String email) {
		
		UserEntity currentUser= userRepository.findByEmail(email);
		
		List<AddressEntity> addresses= currentUser.getAdmin() == true ? (List<AddressEntity>) addressRepository.findAll() : addressRepository.findByUser(currentUser);
		
		Type listType = new TypeToken<List<AddressDto>>() {}.getType();
		List<AddressDto> addressDto = new ModelMapper().map(addresses, listType);
		
		return addressDto;
	}

	
	
	
	@Override
	public AddressDto createAddress(AddressDto address, String email) {
		UserEntity currentUser= userRepository.findByEmail(email);
		ModelMapper modelMapper = new ModelMapper();
		
		UserDto userDto = modelMapper.map(currentUser, UserDto.class);
		address.setAddressId(util.generateStringId(30));
		address.setUser(userDto);
		
		AddressEntity addressEntity = modelMapper.map(address, AddressEntity.class);
		
		AddressEntity newAddress= addressRepository.save(addressEntity);
		AddressDto addressDto = modelMapper.map(newAddress, AddressDto.class);
		
		return addressDto;
	}

	@Override
	public AddressDto getAddress(String addressId) {
		
		AddressEntity addressEntity = addressRepository.findByAddressId(addressId);
		
		ModelMapper modelMapper = new ModelMapper();
		AddressDto addressDto=modelMapper.map(addressEntity, AddressDto.class);
	

		return addressDto;
		
	}

	@Override
	public void deleteAddress(String addressId) {
		
		AddressEntity address = addressRepository.findByAddressId(addressId);
		
		if(address == null) throw new RuntimeException("Address not found");
		
		addressRepository.delete(address);
	
	}

	@Override
	public AddressDto updateAddress(String addressId, AddressDto addressDto) {
		
		
			AddressEntity addressEntity = addressRepository.findByAddressId(addressId);
			if (addressEntity == null)
				throw new UsernameNotFoundException(addressId);
			addressEntity.setCity(addressDto.getCity());
			addressEntity.setCountry(addressDto.getCountry());
			AddressEntity addressUpdated = addressRepository.save(addressEntity);
			
			AddressDto address = new AddressDto();
			BeanUtils.copyProperties(addressUpdated, address);
			
			return address;
		}

}
 