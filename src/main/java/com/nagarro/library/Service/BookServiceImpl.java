package com.nagarro.library.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.library.Dao.BookDao;
import com.nagarro.library.Entities.Book;
import com.nagarro.library.Exceptions.RecordNotFoundException;

@Service
public class BookServiceImpl implements BookService
{
	@Autowired
	private BookDao bookDao;
	
	@Override
	public List<Book> getBooks()
	{
		return bookDao.findAll();
	}
	
	@Override
	public Book getBook(Long id)throws RecordNotFoundException
	{
		Optional<Book> book= bookDao.findById(id);
		if(book.isPresent())
		{
			return book.get();
		}
		else
		{
			 throw new RecordNotFoundException("No student record exist for given id",Long.parseLong(id+""));
		}
	}
	
	@Override
	public void addBook(Book book)
	{
		bookDao.save(book);
	}

	@Override
	public Book updateBook(Long id,Book book_new) throws RecordNotFoundException
	{
		Optional<Book> book_old= bookDao.findById(book_new.getId());
		if(book_old.isPresent())
		{
			Book bandhu =book_old.get();
			bandhu.setName(book_new.getName());
			bandhu.setAuthor(book_new.getAuthor());
			bandhu.setDate(book_new.getDate());
			bookDao.save(bandhu);
			return bandhu;
		}
		else
		{
			throw new RecordNotFoundException("no book exist for given id", id);
		}
	}
	
	@Override
	 public void deleteBook(Long id) throws RecordNotFoundException
	    {
	        Optional<Book> student = bookDao.findById(id);
	         
	        if(student.isPresent())
	        {
	            bookDao.deleteById(Long.parseLong(id+""));
	        } else {
	            throw new RecordNotFoundException("No student record exist for given id",Long.parseLong(id+""));
	        }
	    }
}
