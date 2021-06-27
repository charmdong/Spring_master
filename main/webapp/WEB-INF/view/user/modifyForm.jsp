<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>회원 정보 수정</title>
    </head>

    <body>
        <div id="userInfo_container">
            <form id="infoForm" action="${pageContext.request.contextPath}/user/save" method="POST">
                <label>아이디:<input type="text" name="id" value="${userInfo.id}" readonly="true"></label><br />
                <label>이름:<input type="text" name="userName" value="${userInfo.userName}"></label><br />
                <label>닉네임:</label><input type="text" name="nickName" value="${userInfo.nickName}"><br />
                <lable>이메일:</lable><input type="text" name="email" value="${userInfo.email}"><br />
                <label>연락처:</label><input type="text" name="phone" value="${userInfo.phone}"><br />
                <label>홈페이지:</label><input type="text" name="homepage" value="${userInfo.homepage}"><br />
                <label>소개:</label><br /><textarea name="description" id="" cols="30" rows="10"
                    value="${userInfo.description}"></textarea>

                <button type="button" onclick="validateForm();">수정하기</button>
            </form>
        </div>
        <script>
            function validateForm() {
                let userName = document.getElementsByName("userName")[0];
                let nickName = document.getElementsByName("nickName")[0];
                let phone = document.getElementsByName("phone")[0];

                if (userName.value == "") {
                    alert("Input your name");
                    userName.focus();
                    return false;
                }

                if (nickName.value == "") {
                    alert("Input nick name");
                    nickName.focus();
                    return false;
                }

                if (phone.value == "") {
                    alert("Input nick name");
                    phone.focus();
                    return false;
                }

                infoForm.submit();
            };
        </script>
    </body>

    </html>