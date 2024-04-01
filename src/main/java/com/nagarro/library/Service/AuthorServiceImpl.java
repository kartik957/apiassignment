package com.nagarro.library.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.nagarro.library.Dao.AuthorDao;
import com.nagarro.library.Entities.Author;
import com.nagarro.library.Exceptions.RecordNotFoundException;

@Service
public class AuthorServiceImpl implements AuthorService
{
	@Autowired
	private AuthorDao authordao;
	
	@Override
	public List<Author> getAuthors()
	{
		return authordao.findAll();
	}
	
	@Override
	public Author getAuthor(Long authorId)
	{
		return authordao.getOne(authorId);
	}
	
	@Override
	public void addAuthor(Author author)
	{
		authordao.save(author);
	}
	
	@Override
	public Author updateAuthor(Long id,Author author) throws RecordNotFoundException
	{
		Optional<Author> authors= authordao.findById(id);
		if(authors.isPresent())
		{
			System.out.println(author.toString());
			Author newAuthor= authors.get();
			newAuthor.setName(author.getName());
			System.out.println(newAuthor.toString());
			authordao.save(newAuthor);
			return newAuthor;
		}
		else
		{
			throw new RecordNotFoundException("no author exist for given id", id);
		}
	}
	@Override
	public void deleteAuthor(Long authorId)
	{
		Author author = authordao.getOne(Long.parseLong(authorId+""));
		authordao.delete(author);
	}
}
