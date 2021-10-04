<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.springbook.biz.user.UserVO" %>
<%@ page import="com.springbook.biz.user.impl.UserDAO"%>

<%-- login_proc.jsp는 사용자가 입력한 아이디 비밀번호를 추출하여
         로그인을 처리하는 역할을 함 --%>
         
<%
	// 1. 사용자 입력 정보 추출
	// 사용자가 입력한 아이디(id)와 비밀번호(password)를
	// request 객체로부터 추출한다.
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	
	// 2. DB 연동 처리
	// Model에 해당하는 UserVO와 UserDAO 객체를 이용하여 사용자 정보를 검색한다.
	UserVO vo = new UserVO();
	vo.setId(id);
	vo.setPassword(password);
	
	UserDAO userDAO = new UserDAO();
	UserVO user = userDAO.getUser(vo);
	
	// 3. 화면 네비게이션
	// 검색 결과로 UserVO 객체가 리턴되면 로그인 성공이고,
	// 그렇지 않고(else문) null이 리턴되면 로그인 실패로 처리하고
	// login.jsp 웹페이지로 리다이렉트 처리해 준다.
	if(user != null){
		response.sendRedirect("getBoardList.jsp");
	} else{
		response.sendRedirect("login.jsp");
	}
%>