<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>회원 정보</title>
    </head>

    <body>
        <div id="btn_container">
            <button id="home_btn" onclick="location.assign('${pageContext.request.contextPath}/main')">홈으로</button>
        </div>
        <div id="userInfo_container">
            <label>아이디:<input type="text" name="id" value="${userInfo.id}" readonly="true"></label><br />
            <label>이름:<input type="text" name="userName" value="${userInfo.userName}" readonly="true"></label><br />
            <label>닉네임:</label><input type="text" name="nickName" value="${userInfo.nickName}" readonly="true"><br />
            <label>이메일:</label><input type="text" name="email" value="${userInfo.email}" readonly="true"><br />
            <label>연락처:</label><input type="text" name="phone" value="${userInfo.phone}" readonly="true"><br />
            <label>홈페이지:</label><input type="text" name="homepage" value="${userInfo.homepage}" readonly="true"><br />
            <label>소개:</label><br /><textarea name="description" id="" cols="30" rows="10" readonly="true">${userInfo.description}</textarea>
            <button id="modify_btn" type="button">수정하기</button>
        </div>

        <script>
            window.onload = function() {
                document.getElementById('modfiy_btn').addEventListener("click", function() {
                    if(confirm("개인정보를 수정하시겠습니까?")) {
                        location.assign("${pageContext.request.contextPath}/user/modify");
                    }
                });
            };
        </script>
    </body>
    </html>