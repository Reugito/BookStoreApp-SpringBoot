package com.bridgelabz.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bridgelabz.api.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
