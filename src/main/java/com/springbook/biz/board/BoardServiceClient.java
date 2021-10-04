package com.springbook.biz.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceClient {

	public static void main(String[] args) {

		// 1. Spring 컨테이너를 구동한다.
		AbstractApplicationContext container =
				new GenericXmlApplicationContext("applicationContext.xml");
		
		// 2. Spring 컨테이너로부터 BoardServcieImpl 객체를 Lookup한다.
		BoardService boardService = (BoardService) container.getBean("boardService");
		
		// 3. 글 등록 기능 테스트
		BoardVO vo = new BoardVO();
		vo.setSeq(101);
		vo.setTitle("이것은 임시 제목임~");
		vo.setWriter("김희선");
		vo.setContent("임시 내용을 넣어야 하는데... 음...");
		// boardService.insertBoard(vo);
		
		
		// 4. 글 목록 검색 기능 테스트
		List<BoardVO> boardList = boardService.getBoardList(vo);
		for(BoardVO board : boardList) {
			System.out.println("===> " + board.toString());
		}
		
		// 5. Spring 컨테이너 종료
		container.close();
	}
}
