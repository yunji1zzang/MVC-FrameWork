<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<!-- 로그인에 성공한 다음에는 글 목록 화면(getBoardList.jsp)으로 이동한다.
     getBoardList.jsp는 BOARD 테이블에서 게시글을 검색하여
         글 목록 화면을 구성하는 역할을 한다. -->
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 목록</title>
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
<h1 class="list">글 목록</h1>
<br>
<h3 class="list">
	테스트님 환영합니다. <a href="logout.do">Log-out</a>	
</h3><br>

		<!-- 검색 시작 -->
		<form action="getBoardList.jsp" method="post">
			<table border="1" cellpadding="0" cellspacing="0" width="700">
				<tr>
					<td align="right"><select name="searchCondition">
							<option value="TITLE">제목
							<option value="CONTENT">내용
					</select> <input name="searchKeyword" type="text" /> <input type="submit"
						value="검색" /></td>
				</tr>
			</table>
		</form>
		<!-- 검색 종료 -->
		
		<table border="1" cellpadding="0" cellspacing="0" width="700">
			<tr>
				<th bgcolor="orange" width="100">번호</th>
				<th bgcolor="orange" width="200">제목</th>
				<th bgcolor="orange" width="150">작성자</th>
				<th bgcolor="orange" width="150">등록일</th>
				<th bgcolor="orange" width="100">조회수</th>
			</tr>
		<c:forEach items="${boardList}" var="board">
			<tr>
				<td>${board.seq}</td>
				<td align="left">
				   <a href="getBoard.do?seq=${board.seq}">
				${board.title}</a></td>
				<td>${board.writer}</td>
				<td>${board.regDate}</td>
				<td>${board.cnt}</td>
			</tr>
		</c:forEach>
		
		</table><br>
		<div class="list">
			<a href="insertBoard.jsp">새글 등록</a>
		</div><br><br>
</body>
</html>