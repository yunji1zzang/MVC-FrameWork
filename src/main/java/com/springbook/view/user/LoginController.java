package com.springbook.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;
import com.springbook.view.controller.Controller;

public class LoginController implements Controller{

	@Override
	public String handlerRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("로그인 처리");
		
		// 1. 사용자 입력 정보 추출
		// 사용자가 입력한 아이디(id)와 비밀번호(password)를
		// request 객체로부터 추출한다.
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		// 2. DB 연동 처리
		// Model에 해당하는 UserVO와 UserDAO 객체를 이용하여
		// 사용자 정보를 검색한다.
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPassword(password);
		
		UserDAO userDAO = new UserDAO();
		UserVO user = userDAO.getUser(vo);
		
		// 3. 화면 네비게이션
		if(user != null){
			// 로그인 처리 소스는 앞서 DispatcherServlet의 로그인 처리 기능과 같다.
			// 다만, Controller 인터페이스의 handleRequest() 메서드를
			// 재정의 하였으므로, 로그인 처리 기능의 마지막은 이동할 화면을
			// 리 다이렉트 하지 않고 리턴하는 것으로 처리한다. 
			return "getBoardList.do";
			// 그런데, 로그인에 실패했을 때 이동할 화면 정보가 login.jsp가 아니라
			// 그냥 login 이다. 이것은 handleRequest() 메서드가
			// 확장자 없는 문자열을 리턴하면, 자동으로 ".jsp" 확장자가 붙어서 처리됨 
			// 교재 291p viewResolver, 292p DispatcherServlet 
			// 에서 suffix로 .jsp 붙여주게 됨 
		} else{
			return "login";
		}
	}
}
