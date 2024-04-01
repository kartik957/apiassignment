package com.nagarro.library.Service;

import java.util.List;

import com.nagarro.library.Entities.Author;

public interface AuthorService 
{
	public List<Author> getAuthors();
	public Author getAuthor(Long authorId);
	public void addAuthor(Author author);
	public Author updateAuthor(Long id,Author author);
	void deleteAuthor(Long authorId);
}
