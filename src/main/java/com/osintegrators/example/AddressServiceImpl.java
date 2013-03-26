package com.osintegrators.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	AddressRepository addressRepository;

	public void createAddress(Address address) {
		addressRepository.save(address);
	}

	public List<Address> getAllAddresses() {
		return addressRepository.findAll();

	}

	public void deleteAddress(String id) {
        Address address = addressRepository.findBy_id(id);
        if (address != null){
		    addressRepository.delete(address);
        }
	}

	@Override
	public Address getAddressById(String id) {
		return addressRepository.findBy_id(id);
	}

	@Override
	public void updateAddress(Address address) {

        Address addressInDB = addressRepository.findBy_id(address.get_id());
        addressInDB.setName(address.getName());
        addressInDB.setAddress(address.getAddress());
        addressInDB.setPhone(address.getPhone());
        addressInDB.setEmail(address.getEmail());

        addressRepository.save(address);

	}

}