package com.callor.book.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.book.models.BookDto;
import com.callor.book.service.BookService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {

	protected final BookService bookService;

	public HomeController(BookService bookService) {
		this.bookService = bookService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {

		
		return "main";
	}

	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public String list(Model model) {
		List<BookDto> bookList = bookService.selectAll();
		model.addAttribute("BOOKLIST", bookList);
		return "book/list";

	}

	@RequestMapping(value = "/input", method = RequestMethod.GET)
	public String input(@ModelAttribute("BOOK") BookDto bookDto, Model model) {
		model.addAttribute(model);
		return "book/input";
	}

	@RequestMapping(value = "/input", method = RequestMethod.POST)
	public String input(@ModelAttribute("BOOK") BookDto bookDto) {
		int result = bookService.insert(bookDto);
		if (result > 0) {
			return "redirect:/books";
		} else {

			return "book/input";
		}
	}

	@RequestMapping(value = "/book_detail", method = RequestMethod.GET)
	public String detail(String code, Model model) {
		BookDto bookDto = bookService.findByCode(code);

		model.addAttribute("BOOK", bookDto);
		return "book/detail";
	}

	@RequestMapping(value = "/book_detail", method = RequestMethod.POST)
	public String detail(BookDto bookDto) {
		bookService.update(bookDto);

		return "redirect:/";
	}

	@ModelAttribute("BOOK")
	public BookDto bookDto() {
		BookDto bookDto = new BookDto();
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
		String strDate = dateFormat.format(date);

		int code = bookService.count();
		bookDto.setB_code(String.format("%06d", code + 1));
		bookDto.setB_year(Integer.valueOf(strDate));
		bookDto.setB_use("Y");

		return bookDto;
	}

}
