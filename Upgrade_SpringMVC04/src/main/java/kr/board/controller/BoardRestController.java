package kr.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.board.entity.Board;
import kr.board.mapper.BoardMapper;

@RequestMapping("/board")
@RestController // Ajax 통신
public class BoardRestController {

	@Autowired
	BoardMapper boardmapper;
	
	@GetMapping("/all")
	public List<Board> boardList(){
		List<Board>  list = boardmapper.getLists();
		return list; 
	}
	
//	@RequestMapping("boardInsert.do")
	@PostMapping("/new")
	public void boardInsert(Board vo){
		boardmapper.boardInsert(vo);
	}
	
	@DeleteMapping("/{idx}")
	public void boardDelete(@PathVariable("idx") int idx){
		boardmapper.boardDelete(idx);
	}
	
	@PutMapping("/update")
	public void boardUpdate(@RequestBody Board vo){
		boardmapper.boardUpdate(vo);
	}
	
	@GetMapping("/{idx}")
	public Board boardContent(@PathVariable("idx") int idx){
		Board vo = boardmapper.boardContent(idx);
		return vo;
	}
	
	@PutMapping("/count/{idx}")
	public Board boardCount(@PathVariable("idx") int idx){
		boardmapper.boardCount(idx);
		Board vo = boardmapper.boardContent(idx);
		return vo;
	}

}
