package com.bridgelabz.api.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bridgelabz.api.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query(value = "SELECT * FROM user_registration where email_id=:email_Id", nativeQuery = true)
	 public Optional<User> findByEmailid(String email_Id);
}
