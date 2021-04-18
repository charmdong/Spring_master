<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RequestParam Test</title>
</head>
<body>
    <div>
        <span>아이디</span>
        <input type="text" value="${memberVO.id}">
        
        <span>패스워드</span>
        <input type="password" value="${memberVO.password}"> 
        
        <span>이름</span>
        <input type="text" value="${memberVO.name}">
        
        <span>이메일</span>
        <input type="text" value="${memberVO.email}">
    </div>
</body>
</html>