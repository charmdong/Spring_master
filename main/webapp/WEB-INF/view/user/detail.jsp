<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보</title>
</head>
<body>
    <div id="userInfo_container">
        <label>아이디:<input type="text" name="id" value="${userInfo.id}" readonly="true"></label><br/>
        <label>이름:<input type="text" name="userName" value="${userInfo.userName}" readonly="true"></label><br/>
        <label>닉네임:</label><input type="text" name="nickName" value="${userInfo.nickName}" readonly="true"><br/>
        <lable>이메일:</lable><input type="text" name="email" value="${userInfo.email}" readonly="true"><br/>
        <label>연락처:</label><input type="text" name="phone" value="${userInfo.phone}" readonly="true"><br/>
        <label>홈페이지:</label><input type="text" name="homepage" value="${userInfo.homepage}" readonly="true"><br/>
        <label>소개:</label><br/><textarea name="description" id="" cols="30" rows="10" value="${userInfo.description}" readonly="true"></textarea>
    </div>
</body>
</html>