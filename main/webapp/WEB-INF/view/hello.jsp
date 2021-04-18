<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello world!</title>
</head>
<body>
    <div>
        <span>인사말</span>
        <textbox>${greeting}</textbox>
        <span>${pageContext.request.contextPath}</span>
    </div>

    <div id="buttonBox">
        <button id="btn_login" onclick="location.href='${pageContext.request.contextPath}/member/login'">로그인</button>
        <button id="btn_join" onclick="location.href='${pageContext.request.contextPath}/member/registForm'">회원가입</button>
    </div>

</body>
</html>