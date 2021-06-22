<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
</head>
<body>
	<h1>Hello World!</h1>
    <div>
        <ol>
            <li>
                <button>나의 게시글</button>
            </li>
            <li>
                <button onclick="location.href='${pageContext.request.contextPath}/user/detail?userId=${loginInfo.id}';">마이페이지</button>
            </li>
            <li>
                <button onclick="location.href='${pageContext.request.contextPath}/user/logout';">로그아웃</button>
            </li>
        </ol>
    </div>
</body>
</html>