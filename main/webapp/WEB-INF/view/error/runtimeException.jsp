<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>에러 페이지</title>
</head>
<body>
	<div>
		작업 처리 도중 오류가 발생했습니다. </br>
		관리자에게 문의해주세요.
		<%= exception %>
	</div>
</body>
</html>