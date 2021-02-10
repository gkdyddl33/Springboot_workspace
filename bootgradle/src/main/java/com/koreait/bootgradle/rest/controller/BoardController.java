package com.koreait.bootgradle.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.koreait.bootgradle.model.domain.Board;

@RestController
public class BoardController {
	
	@GetMapping("/rest/board/{board_id}")
	public Board getDetail(@PathVariable int board_id) {
		// 반환형이 String이 아닌 vo 형인경우, Converter가 지원되어야 한다..
		// 스프링 설정 파일.xml jackson jar 다운받아.. MessageConverter.. 설정(스프링부트는 이 등록이 설정 되어있음)
										
		Board board = new Board();
		board.setBoard_id(board_id);
		board.setTitle("난 vo야");
		
		return board;
	}
}
