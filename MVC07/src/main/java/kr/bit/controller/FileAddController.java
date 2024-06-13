package kr.bit.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


public class FileAddController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String UPLOAD_DIR = "file_repo";
		String uploadPath = request.getServletContext().getRealPath("")+File.separator + UPLOAD_DIR;
		File currentDirpath= new File(uploadPath); // 업로드할 경로를 File 객체로 만들기
		if(!currentDirpath.exists()) { //이 디렉토리에 경로가 없으면
			currentDirpath.mkdir();
		}
		//파일을 업로드 할때 먼저 저장될 임시 저장경로를 설정
		// file upload시 필요한 API - commons-fileupload, commons-io
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(currentDirpath);
		factory.setSizeThreshold(1024*1024);
		
		String fileName = null;
		
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {      // items에는 배열처럼 파일 정보들이 담겨 있음
			List<FileItem> items = upload.parseRequest(request); // 파일정보를 쉽게 읽을 수 있게 변환시켜주는 작업 
			//request 안에 여러개의 파일이 업로드 된 경우
			for(int i=0; i<items.size(); i++) {
				FileItem fileItem = items.get(i);
				if(fileItem.isFormField()) { // 폼필드 이면 -> 파라메터이면
					System.out.println(fileItem.getFieldName() + "=" + fileItem.getString("UTF-8"));
				} else {
					if(fileItem.getSize() > 0) {
						int idx = fileItem.getName().lastIndexOf("\\"); // \\(Window)
						if(idx == -1) {
							idx = fileItem.getName().lastIndexOf("/");
						}
						fileName = fileItem.getName().substring(idx+1);
						File uploadFile = new File(currentDirpath+"\\" + fileName);
						//파일이 중복체크
						if(uploadFile.exists()) {
							fileName = System.currentTimeMillis() + "_"+ fileName;
							uploadFile = new File(currentDirpath+"\\" + fileName);
						}
						fileItem.write(uploadFile); //임시경로에서 새로운 경로에 파일쓰기
					}
				}
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		 // $.ajax()쪽으로 업로드된 최종 파일이름을 전송시켜준다.
		response.setContentType("test/html;charset=euc-kr");
		response.getWriter().print(fileName);
		
		
		return null;
	}

}
