package com.nagarro.library.Service;

import java.util.List;

import com.nagarro.library.Entities.Book;

public interface BookService 
{
	public List<Book> getBooks();
	public Book getBook(Long id );
	public void addBook(Book book);
	public Book updateBook(Long id,Book book);
	public void deleteBook(Long id);
}
