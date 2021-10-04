package com.springbook.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;
import com.springbook.view.controller.Controller;

public class UpdateBoardController implements Controller {

	@Override
	public String handlerRequest(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("글 수정 처리");
		
		// 1. 사용자 입력 정보 추출
		// 한글 인코딩은 주석 처리 또는 삭제해도 됨.
		// doPost() 메서드에서 한글 인코딩 처리를 해 줌
		    // request.setCharacterEncoding("UTF-8");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String seq = request.getParameter("seq");
		
		// 2. DB 연동 처리
		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setContent(content);
		vo.setSeq(Integer.parseInt(seq));
		
		BoardDAO boardDAO = new BoardDAO();
		boardDAO.updateBoard(vo);
		
		// 3. 화면 네비게이션
		// UpdateBoardController 역시 글 수정 성공 후에 글 목록을 다시 검색하여
		// 목록 화면을 갱신해야 하므로 getBoardList.do를 리턴한다. 
		return "getBoardList.do";
	}

}
