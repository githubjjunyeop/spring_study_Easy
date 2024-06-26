package kr.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.board.entity.Board;
import kr.board.mapper.BoardMapper;

@Controller
public class BoardController {
	
	@Autowired
	BoardMapper boardmapper;
	
	@RequestMapping("/")
	public String main() {
		return "main";
	}
	
	
	@RequestMapping("boardList.do")
	public @ResponseBody List<Board> boardList(){
		List<Board>  list = boardmapper.getLists();
		return list; 
	}
	
	@RequestMapping("boardInsert.do")
	public @ResponseBody void boardInsert(Board vo){
		boardmapper.boardInsert(vo);
	}
	
	@RequestMapping("boardDelete.do")
	public @ResponseBody void boardDelete(@RequestParam("idx") int idx){
		boardmapper.boardDelete(idx);
	}
	
	@RequestMapping("boardUpdate.do")
	public @ResponseBody void boardUpdate(Board vo){
		boardmapper.boardUpdate(vo);
	}
	
	@RequestMapping("boardContent.do")
	public @ResponseBody Board boardContent(@RequestParam("idx") int idx){
		Board vo = boardmapper.boardContent(idx);
		return vo;
	}
	
	@RequestMapping("boardCount.do")
	public @ResponseBody Board boardCount(@RequestParam("idx") int idx){
		boardmapper.boardCount(idx);
		Board vo = boardmapper.boardContent(idx);
		return vo;
	}
	
}
