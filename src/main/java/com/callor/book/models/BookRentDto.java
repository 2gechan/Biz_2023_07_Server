package com.callor.book.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookRentDto {
	
	private long rent_seq; //	bigint
	private String rent_date; //	varchar(30)
	private String rent_return_date; //	varchar(10)
	private String rent_bcode; //	varchar(6)
	private String rent_ucode; //	varchar(6)
	private String rent_return_yn; //	varchar(1)
	private int rent_point; //	int


}
