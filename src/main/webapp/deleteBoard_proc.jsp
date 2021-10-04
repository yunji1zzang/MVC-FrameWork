<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.springbook.biz.board.impl.BoardDAO" %>
<%@ page import="com.springbook.biz.board.BoardVO"%>

<%-- deleteBoard_proc.jsp 파일에서는 삭제 요청된 게시글 번호를 추출하여
     BoardVO 객체에 저장한다. 이때, getParameter() 메서드는 파라미터값을
         문자열로 리턴하므로 BoardVO 객체에 삭제할 번호를 저장할 때는
     Integer 클래스를 이용하여 int 형으로 변환해야 한다.
         그리고, BoardDAO의 deleteBoard() 메서드를 호출하여
         데이터를 삭제 처리하고 글 목록 화면으로 이동하면 글 삭제 처리를 마무리하게 한다. --%>
         
<%


%>