package com.callor.book.persistance;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.callor.book.models.BookDto;

public interface BookDao {
	
	@Select("select * from tbl_books order by b_code")
	public List<BookDto> selectAll();

	public int insert(BookDto bookDto);

	@Select("select * from tbl_books where b_code = #{code}")
	public BookDto findByCode(String code);
	
	public BookDto findByName(String name);

	public int update(BookDto bookDto);

	@Select("select count(*) from tbl_books")
	public int bookCount();
}
