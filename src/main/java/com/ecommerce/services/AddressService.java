package com.ecommerce.services;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.Entities.Address;
import com.ecommerce.Entities.Users;
import com.ecommerce.dto.AddressRequestBody;
import com.ecommerce.repositories.AddressRepo;

@Service
@Transactional
public class AddressService {
	
	@Autowired
	AddressRepo addressRepo;

	public Address saveAddress(Users checkExisting_User, AddressRequestBody address) {
		Address ad = new Address();
		ad.setCity(address.getCity());
		ad.setHouseNumber(address.getHouseNumber());
		ad.setPincode(address.getPincode());
		ad.setStreet(address.getStreet());
		ad.setCreatedAt(new Date());
		ad.setUpdatedAt(new Date());
		ad.setUser(checkExisting_User);
		return addressRepo.save(ad);
	}

}
