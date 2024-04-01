package com.nagarro.library.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.library.Entities.Book;

public interface BookDao extends JpaRepository<Book, Long>
{

}