<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입</title>
</head>
<body>
    <div id="form_container">
        <form action="" id="joinForm" action="${pageContext.request.contextPath}/user/join">
            <input type="text" name="userName"/>
            <input type="text" name="id"/>
            <input type="text" name="nickName"/>
            <input type="password" name="password"/>
            <input type="password" name="confirmPassword"/>
            <input type="email" name="email"/>
            <input type="tel" name="phone"/>
            <input type="text" name="hoempage">
            <textarea name="description" cols="30" rows="10"></textarea>
        </form>
    </div>
</body>
</html>