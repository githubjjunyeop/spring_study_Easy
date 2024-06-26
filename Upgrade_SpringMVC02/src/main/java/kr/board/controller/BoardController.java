package kr.board.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;


@Controller
public class BoardController {
	
	
	@RequestMapping("/")
	public String main() {
		return "main";
	}
	
	
}
