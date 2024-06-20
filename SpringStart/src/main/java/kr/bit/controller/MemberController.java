package kr.bit.controller;

import java.lang.reflect.Member;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String memberInsert(MemberVO vo) {
		//encoding-filter
		// 파라메터 수집 (VO)
		System.out.println(vo);
		dao.memberInsert(vo);
		
		return "redirect:/memberList.do";
	}
	
	@RequestMapping("/memberRegister.do")
	public String memberRegister() {
		
		return "memberRegister";
	}
	
	@RequestMapping("/memberDelete.do")
	public String memberDelete(int num) { //파라메터를 수집 : num
		//@RequestParam("num") int num
		dao.memberDelete(num);
		
		return "redirect:/memberList.do";
	}
	
	
	@RequestMapping("/memberContent.do")
	public String memberContent(int num, Model model) {
		
		MemberVO vo = dao.memberContent(num);
		// 객체바인딩
		model.addAttribute("vo", vo);
		
		return "memberContent";
	}
	
	@RequestMapping("/memberUpdate.do")
	public String memberUpdate(MemberVO vo) {
		
		dao.memberUpdate(vo);
		
		return "redirect:/memberList.do";
	}
}
