package kr.bit.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FileGetController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		String filename = request.getParameter("filename");
		System.out.println(filename);
		
		String UPLOAD_DIR = "file_repo";
		String uploadPath = request.getServletContext().getRealPath("")+File.separator + UPLOAD_DIR;
		
		File f = new File(uploadPath + "\\" + filename);
		
		// 다운로드 준비 => 중요!!!
		response.setContentLength(f.length());
		return null;
	}

}
