package kr.bit.controller;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.model.MemberDAO;

public class FileDelController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String filename = request.getParameter("filename");
		int num = Integer.parseInt( request.getParameter("num"));
		
		filename = URLEncoder.encode(filename,"UTF-8");
		filename = filename.replace("+", " ");
		
		String UPLOAD_DIR = "file_repo"; // 업로드 실제경로
		String uploadPath = request.getServletContext().getRealPath("")+File.separator + UPLOAD_DIR; 
		
		File file = new File(uploadPath + "\\" + filename);
		
		if(file.exists()) {
			file.delete();
			System.out.println("디렉토리에서 파일 삭제");
		}
		
		//테이블에서도 파일 null 처리(update)
		
		MemberDAO dao = new MemberDAO();
		dao.memberDeleteFile(num);
				
		String ctx = request.getContextPath(); // /MVC07
		
		return "redirect:"+ ctx +"/memberContent.do?num="+num;
	}

}
