package kr.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.oreilly.servlet.MultipartRequest;

import kr.board.entity.Member;
import kr.board.mapper.MemberMapper;

@Controller
public class MemberController {
	
	@Autowired
	MemberMapper memberMapper;
	
	@RequestMapping("/memJoin.do")
	public String memjoin() {
		return "member/join"; 
	}
	
	@RequestMapping("/memRegisterCheck.do")
	public @ResponseBody int memRegisterCheck(@RequestParam("memID") String memID) {
		Member vo = memberMapper.registerCheck(memID);
		if(vo !=null || memID.equals("")) {
			return 0; // 이미 존재하는 회원, 입력불가
		}
		return 1;
	}
	
	@RequestMapping("/memRegister.do")
	public String memRegister(Member m, String memPassword1, String memPassword2,
            RedirectAttributes rttr, HttpSession session) {
		
		if(m.getMemID()==null || m.getMemID().equals("") ||
			memPassword1==null || memPassword1.equals("") ||
			memPassword2==null || memPassword2.equals("") ||
			m.getMemName()==null || m.getMemName().equals("") ||	
			m.getMemAge()==0 ||
			m.getMemGender()==null || m.getMemGender().equals("") ||
			m.getMemEmail()==null || m.getMemEmail().equals("")) {
			// 누락메세지를 가지고 가기? =>객체바인딩(Model, HttpServletRequest, HttpSession)
			rttr.addFlashAttribute("msgType", "실패 메세지");
			rttr.addFlashAttribute("msg", "모든 내용을 입력하세요.");
			return "redirect:/memJoin.do";  // ${msgType} , ${msg}
		}
		if(!memPassword1.equals(memPassword2)) {
			rttr.addFlashAttribute("msgType", "실패 메세지");
			rttr.addFlashAttribute("msg", "비밀번호가 서로 다릅니다.");
			return "redirect:/memJoin.do";  // ${msgType} , ${msg}
		}		
		
		m.setMemProfile(""); // 사진이미는 없다는 의미 ""
		// 회원을 테이블에 저장하기
		int result=memberMapper.register(m);
		if(result==1) { // 회원가입 성공 메세지
			rttr.addFlashAttribute("msgType", "성공 메세지");
			rttr.addFlashAttribute("msg", "회원가입에 성공했습니다.");
			// 회원가입이 성공하면=>로그인처리하기
			session.setAttribute("mvo", m); // ${!empty mvo}
			return "redirect:/";
		}else {
			rttr.addFlashAttribute("msgType", "실패 메세지");
			rttr.addFlashAttribute("msg", "이미 존재하는 회원입니다.");
			return "redirect:/memJoin.do";
		}	
		
	}
	
	@RequestMapping("/memLogout.do")
	public String memLogout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@RequestMapping("/memLoginForm.do")
	public String memLoginForm() {
		return "member/memLoginForm";
	}
	
	
	@RequestMapping("/memLogin.do")
	public String memLogin(Member vo, RedirectAttributes rttr, HttpSession session) {
		
		if(vo.getMemID() == null || vo.getMemID().equals("") || 
		   vo.getMemPassword() == null || vo.getMemPassword().equals("") ) {
			rttr.addFlashAttribute("msgType", "실패 메세지");
			rttr.addFlashAttribute("msg", "모든 내용을 입력해주세요.");
			return "redirect:/memLoginForm.do";
		}
		
		Member mvo =  memberMapper.memLogin(vo);
		if(mvo != null) {
			rttr.addFlashAttribute("msgType", "성공 메세지");
			rttr.addFlashAttribute("msg", "로그인에 성공하셨습니다.");
			session.setAttribute("mvo", mvo);
			return "redirect:/";
		} else {
			rttr.addFlashAttribute("msgType", "실패 메세지");
			rttr.addFlashAttribute("msg", "다시 로그인을 해주세요.");
			return "redirect:/memLoginForm.do";
		}
		
	}
	
	@RequestMapping("/memUpdateForm.do")
	public String memUpdateForm() {
		return "member/memUpdateForm";
	}
		
	@RequestMapping("/memUpdate.do")
	public String memUpdate(Member m, RedirectAttributes rttr, HttpSession session,
			String memPassword1, String memPassword2) {
		if(m.getMemID()==null || m.getMemID().equals("") ||
		   memPassword1==null || memPassword1.equals("") ||
		   memPassword2==null || memPassword2.equals("") ||
		   m.getMemName()==null || m.getMemName().equals("") ||	
		   m.getMemAge()==0 ||
		   m.getMemGender()==null || m.getMemGender().equals("") ||
		   m.getMemEmail()==null || m.getMemEmail().equals("")) {
				// 누락메세지를 가지고 가기? =>객체바인딩(Model, HttpServletRequest, HttpSession)
		   rttr.addFlashAttribute("msgType", "실패 메세지");
		   rttr.addFlashAttribute("msg", "모든 내용을 입력하세요.");
		   return "redirect:/memUpdateForm.do";  // ${msgType} , ${msg}
		}
		
		if(!memPassword1.equals(memPassword2)) {
			
		    rttr.addFlashAttribute("msgType", "실패 메세지");
			rttr.addFlashAttribute("msg", "비밀번호가 서로 다릅니다.");
			return "redirect:/memUpdateForm.do";  // ${msgType} , ${msg}
		}		
			
			m.setMemProfile(""); // 사진이미는 없다는 의미 ""
			// 회원을 테이블에 저장하기
			int result=memberMapper.memUpdate(m);
			
		if(result==1) { // 수정 성공 메세지
			rttr.addFlashAttribute("msgType", "성공 메세지");
			rttr.addFlashAttribute("msg", "회원정보 수정을 성공했습니다.");
			// 회원수정이 성공하면=> 메세지
			session.setAttribute("mvo", m); // ${!empty mvo}
			return "redirect:/";
			
		}else {
			rttr.addFlashAttribute("msgType", "실패 메세지");
			rttr.addFlashAttribute("msg", "회원정보 수정을 실패했습니다.");
			return "redirect:/memUpdateForm.do";
		}	
		
	}
	
	@RequestMapping("/memImageForm.do")
	public String memImageForm() {
		return "member/memImageForm";
	}
	
	//회원사진 이미지 업로드(upload, DB저장)
	@RequestMapping("/memImageUpdate.do")
	public String memImageUpdate(HttpServletRequest request) {
		// 파일 업로드 API(cos.jar, 3가지)
		MultipartRequest multi = null;
		int fileMaxSize = 10*1024-1024; // 10MB
		String savePath = request.getRealPath("resources/upload");
		
		return "";
	}
}
