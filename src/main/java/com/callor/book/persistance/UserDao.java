package com.callor.book.persistance;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.callor.book.models.UserDto;

public interface UserDao {
	
	@Select("select * from tbl_users where u_code = #{id}")
	public UserDto findById(String id);
	
	public int insert(UserDto userDto);
	
	@Select("select count(*) from tbl_users")
	public int userCount();

	@Select("select * from tbl_users order by u_code")
	public List<UserDto> selectAll();

	public int update(UserDto userDto);

}
