<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>Login Page</title>
</head>

<body>
	<h2>로그인</h2>
	<form id="loginfrm" name="loginfrm" method="POST" action="login/process">
		<table>
			<tr height="40px">
				<td>유저ID</td>
				<td><input type="text" id="loginid" name="loginid" value=""></td>
			</tr>
			<tr height="40px">
				<td>패스워드</td>
				<td><input type="password" id="loginpwd" name="loginpwd"></td>
			</tr>
		</table>
		<table>
			<tr>
				<td align="center"><input type="submit" value="로그인"></td>
				<td align="center"><input type="reset" value="리셋"></td>
			</tr>
		</table>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> 
	</form>
</body>
</html>
