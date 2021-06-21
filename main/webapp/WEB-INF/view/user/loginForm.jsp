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
            <form action="${pageContext.request.contextPath}/user/login" method="post">
                <label for="">아이디</label>
                <input type="text" name="userId" id="userId" placeholder="Input your ID"><br/>

                <label for="">패스워드</label>
                <input type="password" name="password" id="userPwd"><br/>

                <button type="submit">로그인</button>
            </form>
        </div>
    </div>
</body>
</html>