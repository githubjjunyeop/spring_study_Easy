package kr.inflearn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.inflearn.mapper.BoardMapper;
import kr.inflearn.model.BoardVO;

@Service
public class BoardSreviceimpl implements BoardService{
	
	@Autowired
	private BoardMapper mapper; // DI 의존성 주입

	@Override
	public List<BoardVO> getList() {
		
		return mapper.getList();
	}

	@Override
	public void register(BoardVO board) {
		mapper.insert(board);
		
	}

	@Override
	public BoardVO get(int bno) {
		return mapper.read(bno);
	}

	@Override
	public int remove(int bno) {
		return mapper.delete(bno);
	}

	@Override
	public int modify(BoardVO board) {
		return mapper.update(board);
	}

	

}
