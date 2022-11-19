package com.ecommerce.controllers;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.Entities.Users;

import com.ecommerce.dto.UserRegisterRequestBody;
import com.ecommerce.dto.UserUpdateRequestBody;
import com.ecommerce.services.UsersService;


@RestController
public class UserController {

	Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UsersService userService;

	@PostMapping("/signup")
	public ResponseEntity<?> userRegister(@Valid @RequestBody UserRegisterRequestBody user) {
            
		try {
			// Check to see if the users exists by the email id  then show user already exits
			  Users checkExisting_User = userService.findByEmail(user.getEmail());
			  if (checkExisting_User != null) {
				  logger.info("user already exists");

					return new ResponseEntity<>("user already exists", HttpStatus.CONFLICT);
			  }
			logger.info("Received user {}", user);
			// If the user doesn't exist then create user a response of user created.
			Users userSaved = this.userService.saveUser(user);
			logger.info("user saved");
			return new ResponseEntity<>(userSaved, HttpStatus.CREATED);

		} catch (Exception e) {
			logger.info(e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.FAILED_DEPENDENCY);

		}

	}

	@GetMapping("/getallusers")
	public ResponseEntity<?> getAllUser() {
		List<Users> users;
		try {
			// Check to see if the List of users not exists in database  then show user not found
			
			users = userService.getAllUser();
			if (users.isEmpty()) {
				logger.info("not found any users");
				return new ResponseEntity<>("Not found any users", HttpStatus.NO_CONTENT);
			}
			logger.info("user found");
			return new ResponseEntity<>(users, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	

	@GetMapping("/users/{userId}")
	public ResponseEntity<?> getOneUser(@Valid @PathVariable int userId) {
		Users temp = null;
		try {
			temp = userService.getOneUser(userId);
			logger.info("user details found");
			return new ResponseEntity<>(temp, HttpStatus.ACCEPTED);

		} catch (Exception e) {

			logger.error("Exception occured, {}", e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PutMapping("/updateuser/{userId}")
	public ResponseEntity<?> updateUser(@PathVariable int userId,@Valid @RequestBody UserUpdateRequestBody user) {
		Users temp = null;
		try {
			temp = this.userService.updateUser(userId, user);
			logger.info("user updated successfully");
			return new ResponseEntity<>(temp, HttpStatus.ACCEPTED);

		} catch (Exception e) {
			logger.info(e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.FAILED_DEPENDENCY);
		}

	}

	@DeleteMapping("/deleteuser/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable int userId) {
		try {
			
			//// Check to see if the users not exists by user id  then show user not found 
			Users user = userService.getOneUser(userId);
			if(user==null) {
				logger.info("user not found for this user id");
				return new ResponseEntity<>("user not found for this user id",HttpStatus.BAD_REQUEST);
			}
			userService.deleteUser(userId);
			logger.info("user successfully deleted");
			return new ResponseEntity<String>("user has been deleted successfully", HttpStatus.OK);
		} catch (Exception e) {
			logger.info(e.getMessage());
			return new ResponseEntity<String>("user has not been deleted", HttpStatus.NOT_FOUND);

		}

	}
	
	
//	@PostMapping("/loginuser")
//	public ResponseEntity<?> loginUser(@Valid @RequestBody UserLoginRequestBody user ){
//		
//	}

}
