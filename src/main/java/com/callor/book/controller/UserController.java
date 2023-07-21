package com.callor.book.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.book.models.BookDto;
import com.callor.book.models.UserDto;
import com.callor.book.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping(value = "/user")
public class UserController {

	protected final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/ulist", method = RequestMethod.GET)
	public String ulist(Model model) {
		List<UserDto> userList = userService.selectAll();
		model.addAttribute("USERLIST", userList);
		return "user/ulist";
	}

	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join(@ModelAttribute("USER") UserDto userDto, Model model) {
		model.addAttribute("USER", userDto);

		return "user/join";
	}

	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(@ModelAttribute("USER") UserDto userDto) {
		userService.join(userDto);
		return "redirect:/";
	}

	@RequestMapping(value = "/user_detail", method = RequestMethod.GET)
	public String detail(Model model, String id) {
		UserDto userDto = userService.findById(id);
		model.addAttribute("USER", userDto);
		return "user/detail";
	}

	@RequestMapping(value = "/user_detail", method = RequestMethod.POST)
	public String detail(UserDto userDto) {
		userService.update(userDto);

		return "redirect:/user/ulist";
	}

	@ModelAttribute("USER")
	public UserDto userDto() {
		UserDto userDto = new UserDto();
		int count = userService.count();
		userDto.setU_code(String.format("%06d", count + 1));
		return userDto;
	}

}
