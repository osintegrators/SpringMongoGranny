package com.osintegrators.example;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends MongoRepository<Address, Long> {

	List<Address> findAll();

    @Query("{ name : ?0 }")
	Address findByName(String name);

}
