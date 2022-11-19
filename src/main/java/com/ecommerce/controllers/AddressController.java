package com.ecommerce.controllers;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.Entities.Address;
import com.ecommerce.Entities.Users;
import com.ecommerce.dto.AddressRequestBody;
import com.ecommerce.services.AddressService;
import com.ecommerce.services.UsersService;

@RestController
public class AddressController {
	Logger logger = LoggerFactory.getLogger(AddressController.class);
	@Autowired
	AddressService addressService;

	@Autowired
	UsersService userService;

	@PostMapping("/address/{userId}")
	public ResponseEntity<?> addAddress(@Valid @PathVariable int userId,@Valid @RequestBody AddressRequestBody address) {
		try {
			// Check to see if the users does not exists by the user id then show user not exits
			Users checkExisting_User = userService.getUserById(userId);
			if (checkExisting_User == null) {
				logger.info("user not exists with this userId");

				return new ResponseEntity<>("user not exists", HttpStatus.CONFLICT);
			}

			Address add = this.addressService.saveAddress(checkExisting_User, address);
			return new ResponseEntity<>(add, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

}
