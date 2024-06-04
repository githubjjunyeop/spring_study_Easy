package kr.bit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	// 모든 POJO가 가지고 있어야 되는 메서드
	// return 값이 왜 String 으로 반환되는 가 (다음페이지 정ㅂ)
	public String requestHandler(HttpServletRequest request, HttpServletResponse reponse) 
															throws ServletException, IOException;
}
