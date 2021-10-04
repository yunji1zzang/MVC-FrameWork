<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!-- 글 등록 기능은 insertBoard.jsp 파일을 생성하여
         글 등록 화면을 구성한다.  -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>새글 등록</title>
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
<h1 class="list">글 등록</h1>
<br>
<div class="list">
	<a href="logout.do">Log-out</a>
</div>
<br><hr><br>
<form action="insertBoard.do" method="post">
	
	<table border="1" cellpadding="0" cellspacing="0">
		<tr>
			<td bgcolor="orange" width="70">제목</td>
			<td align="left"><input name="title" type="text"/></td>
		</tr>
		<tr>
			<td bgcolor="orange">작성자</td>
			<td align="left"><input type="text" name="writer"
				size="10" /></td>			
		</tr>
		<tr>
			<td bgcolor="orange">내용</td>
			<td align="left"><textarea rows="10" cols="40"
				 name="content"></textarea></td>
		</tr>		
		<tr>
			<td colspan="2" align="center"><input type="submit"
				value="새글 등록" /></td>
		</tr>
	</table>
</form>
<br>
<hr>
<br>
<div class="list">
<a href="getBoardList.jsp">글 목록 가기</a>
</div>
<br><br>
</body>
</html>