package com.callor.book.service;

import java.util.List;

import com.callor.book.models.BookDto;


public interface BookService {
	public int insert(BookDto bookDto);
	
	public List<BookDto> selectAll();
	
	public int update(BookDto bookDto);

	public BookDto findByCode(String code);
	
	public BookDto findByName(String name);
	
	public int count();
}
