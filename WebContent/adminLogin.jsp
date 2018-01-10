<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<span>${info}</span>
	<form action="AdminAction.do?method=login" method="POST">
		<div>管理id：<input type="text" name="adminid"></div>
		<div>管理密码：<input type="password" name="password"></div>
		<button type="submit">登录</button>
	</form>
</body>
</html>