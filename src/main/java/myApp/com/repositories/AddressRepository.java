package myApp.com.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import myApp.com.entities.AddressEntity;
import myApp.com.entities.UserEntity;


@Repository
public interface AddressRepository extends CrudRepository<AddressEntity, Long>{
	
	List<AddressEntity> findByUser(UserEntity currentUser);
	
	AddressEntity findByAddressId(String addressId);

}
