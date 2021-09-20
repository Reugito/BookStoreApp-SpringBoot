package com.bridgelabz.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bridgelabz.api.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {

}
