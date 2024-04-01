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

import com.nagarro.library.Service.AuthorService;
import com.nagarro.library.Entities.Author;
import com.nagarro.library.Entities.Book;

@RestController
@RequestMapping("/authors")
public class AuthorController 
{
	@Autowired
	private AuthorService autorService;
	
	@GetMapping("/get")
	public ResponseEntity<List<Author>> getAuthorsController()
	{
		List<Author> authors =autorService.getAuthors();
		return new ResponseEntity<>(authors, HttpStatus.OK);
	}
	
	@GetMapping("/get/{authorId}")
	public ResponseEntity<Author> getAuthorController(@PathVariable String authorId)
	{
		Author new_author=autorService.getAuthor(Long.parseLong(authorId));
		return new ResponseEntity<>(new_author, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<HttpStatus> addAuthorController(@RequestBody Author author)
	{
		try 
		{
			this.autorService.addAuthor(author);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PutMapping("/update/{authorId}")
	public ResponseEntity<HttpStatus> updateAuthorController(@PathVariable Long authorId,@RequestBody Author author)
	{
		try
		{
			this.autorService.updateAuthor(authorId,author);
			return new ResponseEntity<>(HttpStatus.OK);	
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/delete/{authorId}")
	public ResponseEntity<HttpStatus> deleteAuthorController(@RequestBody Author author)
	{
		try 
		{
			this.autorService.deleteAuthor(author.getId());
			return new ResponseEntity<>(HttpStatus.OK);	
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
