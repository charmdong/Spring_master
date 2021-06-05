<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<div>
        <div id="loginContainer">
            <form action="${pageContext.request.contextPath}/user/login" method="get">
                <input type="text" name="id" id="userId" placeholder="Input your ID">
                <input type="password" name="password" id="userPwd">
                <input type="submit" value="로그인">
            </form>
        </div>
    </div>
</body>
</html>