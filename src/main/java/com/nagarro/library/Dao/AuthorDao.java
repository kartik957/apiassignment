package com.nagarro.library.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.library.Entities.Author;

public interface AuthorDao extends JpaRepository<Author, Long>
{

}
