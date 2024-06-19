package kr.bit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.bit.model.MemberDAO;
import kr.bit.model.MemberVO;

// @ ->어노테이션(전처리) ->Spring Container에서 관리를 해준다.
@Controller
public class MemberController {
	
	@Autowired
	private MemberDAO dao;
	
	@RequestMapping("/memberList.do")
	public String memberList(Model model) {
		List<MemberVO> list= dao.memberList();
		// 객체바인딩
		model.addAttribute("list", list);
		return "memberList";
	}
	
	
	@RequestMapping("/memberInsert.do")
	public String memberInsert() {
		
		return "redirect:/memberList.do";
	}
	
	@RequestMapping("/memberRegister.do")
	public String memberRegister() {
		
		return "memberRegister";
	}
}
