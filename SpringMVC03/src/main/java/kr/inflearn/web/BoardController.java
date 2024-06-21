package kr.inflearn.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.inflearn.model.BoardVO;
import kr.inflearn.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	@RequestMapping("/list.do")
	public String list(Model model) {
		List<BoardVO> list = service.getList();
		model.addAttribute("list",list);
		return "boardList";
	}
	
	@RequestMapping(value="/register.do", method=RequestMethod.GET)
//	@GetMapping
	public String registerGET() { 
		return "register"; // register.jsp(게시물 등록화면)
	}
	
//	@PostMapping
	@RequestMapping(value="/register.do", method=RequestMethod.POST)
	public String registerPOST(BoardVO board) { // 게시물 등록
		service.register(board);
		return "redirect:/list.do"; // 게시물 보기
	}
}


/*
	/list.do    ---> GET ---> list()
	/register.do --> POST --->  register();
	/read.do     --> GET --->  read();
	/remove.do   --> GET --->  remove();
	/modify.do   --> POST --->  modify();
	 
*/