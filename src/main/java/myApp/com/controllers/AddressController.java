package myApp.com.controllers;

import java.lang.reflect.Type;
import java.security.Principal;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import myApp.com.requests.AddressRequest;
import myApp.com.responses.AddressResponse;
import myApp.com.services.AddressService;
import myApp.com.shared.dto.AddressDto;

@RestController
@RequestMapping("/addresses")
public class AddressController {
	
	@Autowired
	AddressService addressService;
	
	@GetMapping
	public ResponseEntity<List<AddressResponse>>getAddress(Principal principal){
		
		List<AddressDto> addresses= addressService.getAllAddresses(principal.getName());
		
		Type listType = new TypeToken<List<AddressResponse>>() {}.getType();
		List<AddressResponse> addressResponse = new ModelMapper().map(addresses, listType);
		
		
		return new ResponseEntity<List<AddressResponse>>(addressResponse, HttpStatus.OK);
	}
	
	@PostMapping(  
			
			 consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE , MediaType.MULTIPART_FORM_DATA_VALUE},
			 produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
		           )
	public ResponseEntity<AddressResponse> storeAddress(@RequestBody AddressRequest addressRequest , Principal principal){
		
		ModelMapper modelMapper = new ModelMapper();
		
		AddressDto addressDto = modelMapper.map(addressRequest, AddressDto.class);
		
		AddressDto createAddress = addressService.createAddress(addressDto , principal.getName());
		
		AddressResponse newAddress=modelMapper.map(createAddress, AddressResponse.class);
		
		return new ResponseEntity<AddressResponse>(newAddress,HttpStatus.CREATED);
	}

	
	@GetMapping(path="/{id}",produces={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	 
	public ResponseEntity<AddressResponse> getOneAddress(@PathVariable(name="id") String addressId ) {
		AddressDto addressDto= addressService.getAddress(addressId);
		ModelMapper modelMapper = new ModelMapper();
		
		AddressResponse addressResponse=modelMapper.map(addressDto, AddressResponse.class);
		
		return new ResponseEntity<AddressResponse>(addressResponse,HttpStatus.OK);
	}
	
	
	@PutMapping(path="/{id}",
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<AddressResponse> updateAddress(@PathVariable(name="id") String addressId , @RequestBody AddressRequest addressDetails) {
		
		ModelMapper modelMapper = new ModelMapper();
		
		AddressDto addressDto =modelMapper.map(addressDetails, AddressDto.class);
		
		
		AddressDto addresDto = addressService.updateAddress(addressId ,addressDto);
		
		AddressResponse addressResponse =modelMapper.map(addresDto, AddressResponse.class);
		
		
		return new ResponseEntity<AddressResponse>(addressResponse,HttpStatus.ACCEPTED);
	}
	//public ResponseEntity<String> updatreAddresse(@PathVariable(name="id") String addressId) {
		//return new ResponseEntity<>("update addresses", HttpStatus.ACCEPTED);
	//}
	@DeleteMapping(path="/{id}")
	public ResponseEntity<?> deleteAddress(@PathVariable(name="id") String addressId ) {
		
		addressService.deleteAddress(addressId);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
		
	}
	
	
}
