package kr.bit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.bit.model.MemberDAO;
import kr.bit.model.MemberVO;

public class MemberAjaxListController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		MemberDAO dao = new MemberDAO();
		List<MemberVO> list = dao.memberList();
		// Gson API
		
		Gson g = new Gson();
		String json = g.toJson(list);
		System.out.println(json); // json 배열 형식으로 나와야댐
		// $.ajax()  -->json 형태로 응답
		response.setContentType("text/json;charset=euc-kr");
		response.getWriter().print(json);
		
		return null;
	}

}
