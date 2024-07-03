package kr.board.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;


@Controller
public class BoardController {
	
	
	@RequestMapping("/boardMain.do")
	public String main() {
		return "board/main";
	}
	
	
}
