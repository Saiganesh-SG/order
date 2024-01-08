package com.example.order.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.order.entity.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {

}
