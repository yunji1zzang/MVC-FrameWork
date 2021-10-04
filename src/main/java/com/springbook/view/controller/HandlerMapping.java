package com.springbook.view.controller;

import java.util.HashMap;  
import java.util.Map;

import com.springbook.view.board.DeleteBoardController;
import com.springbook.view.board.GetBoardController;
import com.springbook.view.board.GetBoardListController;
import com.springbook.view.board.InsertBoardController;
import com.springbook.view.board.UpdateBoardController;
import com.springbook.view.user.LoginController;
import com.springbook.view.user.LogoutController;

//HandlerMapping은 모든 Controller 객체들을 저장하고 있다가,
//클라이언트의 요청이 들어오면 요청을 처리할 특정 Controller를 검색하는 기능을 제공함. 

public class HandlerMapping {
	
	// HandlerMapping은 Map 타입의 컬렉션을 멤버변수로 가지고 있으면서
	// 게시판 프로그램에 필요한 모든 Controller 객체들을 등록하고 관리한다. 
	// HandlerMapping 객체는 DispatcherServlet이 사용하는 객체이다. 
	// 따라서, DispatcherServlet이 생성되고 init() 메서드가 호출될 때 단 한 번 생성된다. 
	private Map<String, Controller> mappings;
	
	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		mappings.put("/login.do", new LoginController());
		mappings.put("/getBoardList.do", new GetBoardListController());
		mappings.put("/getBoard.do", new GetBoardController());
		mappings.put("/insertBoard.do", new InsertBoardController());
		mappings.put("/updateBoard.do", new UpdateBoardController());
		mappings.put("/deleteBoard.do", new DeleteBoardController());
		mappings.put("/logout.do", new LogoutController());

	} 
	// getController() 메서드는 매개변수로 받은 path에 해당하는
	// Controller 객체를 HashMap 컬렉션으로부터 검색하여 리턴한다.
	// 지금은 LoginController 객체 하나만 등록되어 있지만,
	// 앞으로 계속 Controller 객체들이 추가될 것이다.
	// 따라서 HashMap에 등록된 정보를 보면 Controller 객체가
	// 어떤 ".do" 요청과 매핑되어 있는지 확인할 수 있다.
	public Controller getController(String path) {
		return mappings.get(path);
	}
}