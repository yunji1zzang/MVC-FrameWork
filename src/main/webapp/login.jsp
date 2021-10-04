<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<style>

*{
	margin:0 auto;
	padding:0;
	list-style:none;
	font-family:"맑은 고딕";	
}

.login{
	text-align: center;
}


</style>


</head>
<body>
<br>
<h1 class="login">로그인</h1><br>
<hr><br>
<form class="inputForm" action="login.do" method="post">

<table class="layer" border="1" cellpadding = "0" cellspacing="0">
	<tr>
		<td bgcolor="orange">아이디</td>
		<td><input type="text" name="id"></td>
	</tr>
	<tr>
		<td bgcolor="orange">비밀번호</td>
		<td><input type="password" name="password"></td>
	</tr>
	<tr>
		<td colspan="2" align="center">
		<input type="submit" value="로그인"></td>
	</tr>	
</table>
</form><br>
<hr>

</body>

</html>