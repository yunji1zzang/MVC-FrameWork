<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.springbook.biz.board.impl.BoardDAO" %>
<%@ page import="com.springbook.biz.board.BoardVO" %>

<%
	// 세션에 저장된 게시글 정보를 꺼낸다.
	BoardVO board = (BoardVO) session.getAttribute("board");
%>

<!-- 글 목록 화면에서 사용자가 클릭한 게시글을 조회하고,
         조회된 게시글의 상세 화면을 제공하는
     getBoard.jsp 파일을 작성한다. -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 상세</title>
<style>

*{
	margin:0 auto;
	padding:0;
	list-style:none;
	font-family:"맑은 고딕";	
}

.list{
	text-align: center;
}

</style>

</head>
<body>
<br>
<h1 class="list">글 상세</h1>
<br>
<div class="list">
	<a href="logout.do">Log-out</a>
</div>
<br><hr><br>
<!-- 글 수정 처리는 updateBoard_proc.jsp 파일에서 진행한다. -->
<form action="updateBoard.do" method="post">

	<!-- 글 수정 시 글 상세 화면(getBoard.jsp)이 글 수정에 사용 된다.
	     이때, 글 수정 처리를 진행 하려면, 수정할 글의 제목과 내용 뿐만 아니라,
	     게시글 번호로 알야아 한다. 따라서, 상세 화면을 출력할 때 form 태그 밑에
	   HIDDEN 타입의 input 태그를 추가하여 수정할 게시글 번호도 같이
	     전달될 수 있도록 코딩해야 한다. -->
	<input name="seq" type="hidden" value="<%=board.getSeq()%>" />
	<table border="1" cellpadding="0" cellspacing="0">
		<tr>
			<td bgcolor="orange" width="70">제목</td>
			<td align="left"><input name="title" type="text"
				value="<%=board.getTitle()%>" /></td>
		</tr>
		<tr>
			<td bgcolor="orange">작성자</td>
			<td align="left"><%=board.getWriter()%></td>			
		</tr>
		<tr>
			<td bgcolor="orange">내용</td>
			<td align="left"><textarea rows="10" cols="40"
				 name="content"><%=board.getContent()%>
				 </textarea></td>
		</tr>
		<tr>
			<td bgcolor="orange">등록일</td>
			<td align="left"><%=board.getRegDate()%></td>			
		</tr>
		<tr>
			<td bgcolor="orange">조회수</td>
			<td align="left"><%=board.getCnt()%></td>			
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit"
				value="글 수정" /></td>
		</tr>
	</table>
</form>
<br>
<hr>
<br>
<div class="list">
<a href="insertBoard.jsp">글등록</a>&nbsp;&nbsp;&nbsp;
<!-- 사용자가 상세 화면에서 글 삭제 링크를 클릭하면 deleteBoard_proc.jsp 파일에서
         해당 게시글을 삭제 처리하면 된다. 이때 삭제할 게시글 번호를
     deleteBoard_proc.jsp 파일에 알려줘야 하므로
     deleteBoard_proc.jsp 뒤에 seq 파라미터 정보를 추가한다.-->
<a href="deleteBoard.do?seq=<%=board.getSeq()%>">글삭제
</a>&nbsp;&nbsp;&nbsp;
<a href="getBoardList.do">글목록</a>
</div>
<br><br>
</body>
</html>