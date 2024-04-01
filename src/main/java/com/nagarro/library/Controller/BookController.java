package com.nagarro.library.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.library.Entities.Author;
import com.nagarro.library.Entities.Book;
import com.nagarro.library.Service.AuthorService;
import com.nagarro.library.Service.BookService;

@RestController
@RequestMapping("/books")
public class BookController 
{
	@Autowired
	private BookService bookService;
	
	@Autowired
	private AuthorService authorService;
	
	@GetMapping("/get")
	public ResponseEntity<List<Book>> getAllBooks()
	{
		List<Book> books = bookService.getBooks();
		return new ResponseEntity<>(books, HttpStatus.OK);
	}
	
	@GetMapping("/get/{bookId}")
	public ResponseEntity<Book> getBook(@PathVariable String bookId)
	{
		Book new_book=bookService.getBook(Long.parseLong(bookId));
		return new ResponseEntity<>(new_book, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<HttpStatus> addAuthorController(@RequestBody Book book)
	{
		try 
		{
			this.bookService.addBook(book);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/update/{bookId}")
	public ResponseEntity<HttpStatus> updateBookController(@PathVariable Long id,@RequestBody Book book)
	{
		try 
		{
			this.bookService.updateBook(id,book);
			return new ResponseEntity<>(HttpStatus.OK);	
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/delete/{bookId}")
	public ResponseEntity<HttpStatus> deleteAuthorController(@RequestBody Book book)
	{
		try 
		{
			this.bookService.deleteBook(book.getId());
			return new ResponseEntity<>(HttpStatus.OK);	
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
