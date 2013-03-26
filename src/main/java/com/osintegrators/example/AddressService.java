package com.osintegrators.example;

import java.util.List;

import com.osintegrators.example.Address;

public interface AddressService {

	void createAddress(Address add);

	void deleteAddress(String id);

	List<Address> getAllAddresses();

	Address getAddressById(String id);

	void updateAddress(Address address);

}
