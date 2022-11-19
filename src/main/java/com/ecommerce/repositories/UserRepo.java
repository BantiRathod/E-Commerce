package com.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.Entities.Users;

@Repository
public interface UserRepo extends JpaRepository<Users, Integer> {

	Users findByEmail(String email);

}
