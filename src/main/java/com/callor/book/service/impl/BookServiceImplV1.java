package com.callor.book.service.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.callor.book.models.BookDto;
import com.callor.book.persistance.BookDao;
import com.callor.book.service.BookService;

@Service
public class BookServiceImplV1 implements BookService {

	protected final BookDao bookDao;

	public BookServiceImplV1(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	@Override
	public int insert(BookDto bookDto) {
		
		return bookDao.insert(bookDto);
	}

	@Override
	public List<BookDto> selectAll() {
		List<BookDto> bookList = bookDao.selectAll();
		for(int i=0; i<bookList.size(); i++) {
			if(bookList.get(i).getB_use().equals("N")) {
				bookList.remove(i);
			};
		}
		
		return bookList;
	}

	@Override
	public int update(BookDto bookDto) {
		bookDao.update(bookDto);
		return 0;
	}

	@Override
	public BookDto findByCode(String code) {
		BookDto bookDto = bookDao.findByCode(code);

		return bookDto;
	}
	
	@Override
	public BookDto findByName(String name) {
		BookDto book = bookDao.findByName(name);
		return book;
	}

	@Override
	public int count() {
		
		return bookDao.bookCount();
	}

}
