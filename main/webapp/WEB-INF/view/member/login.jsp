<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	
	<form:form commandName="memberVO">
		<form:errors element="div"/>
		<label for="id">아이디</label>
		<input type="text" name="id" id="id" value="${memberVO.id} ">
		<form:errors path="id" /> <br/>
		
		<form:errors element="div"/>
		<label for="password">패스워드</label>
		<input type="password" name="password" id="password">
		<form:errors path="password" /> <br/>
		<br/>
		
		<input type="submit" value="로그인">
	</form:form>

</body>
</html>