package com.koreait.bootapp20210208.model.board.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.koreait.bootapp20210208.exception.BoardUpdateException;
import com.koreait.bootapp20210208.model.domain.Board;
@Repository
public class MybatisBoardDAO implements BoardDAO{

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public List selectAll() {
		return sqlSessionTemplate.selectList("Board.selectAll");
	}

	public Board select(int board_id) {
		return sqlSessionTemplate.selectOne("Board.select", board_id);
	}

	public void insert(Board board) throws BoardUpdateException{
		int result = sqlSessionTemplate.insert("Board.insert", board);
		if(result==0) {
			throw new BoardUpdateException("등록실패");
		}
	}

	public void update(Board board) throws BoardUpdateException{
		int result = sqlSessionTemplate.update("Board.update",board);
		if(result==0) {
			throw new BoardUpdateException("수정실패");
		}
		
	}

	public void delete(int board_id) throws BoardUpdateException{
		int result = sqlSessionTemplate.delete("Board.delete",board_id);
		if(result==0) {
			throw new BoardUpdateException("삭제실패");
		}
	}

}
