package kr.inflearn.service;

import java.util.List;

import kr.inflearn.mapper.BoardMapper;
import kr.inflearn.model.BoardVO;

public class BoardSreviceimpl implements BoardService{
	
	private BoardMapper mapper;

	@Override
	public List<BoardVO> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void register(BoardVO board) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BoardVO get(int bno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int remove(int bno) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modify(BoardVO board) {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
