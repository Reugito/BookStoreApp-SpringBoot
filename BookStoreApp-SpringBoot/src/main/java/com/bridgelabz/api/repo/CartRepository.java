package com.bridgelabz.api.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bridgelabz.api.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {

	@Query(value = "SELECT * FROM cart_service where user_id = :user_id", nativeQuery = true)
	List<Cart> findAllCartsByUserId(Long user_id);
}
