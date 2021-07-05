<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>회원 정보 수정</title>
    </head>
    <script src="https://code.jquery.com/jquery-3.4.1.js"></script>
    <script>
        window.onload = function() {
            $.ajax({
                type: "GET",
                data: "json",
                url: "${pageContext.request.contextPath}/userApi/getUserInfo?userId=${loginInfo.id}",
                success: function(res) {
                    setUserInfo(res);
                },
                error: function(data) {
                    alert("개인 정보 조회 과정에서 문제가 발생했습니다. \n 관리자에게 문의해주시기 바랍니다.");
                }
            });
        };

        function setUserInfo(userInfo) {
            $('input[name="id"]').val(userInfo.id);
            $('input[name="userName"]').val(userInfo.userName);
            $('input[name="nickName"]').val(userInfo.nickName);
            $('input[name="email"]').val(userInfo.email);
            $('input[name="phone"]').val(userInfo.phone);
            $('input[name="homepage"]').val(userInfo.homepage);
            $('textarea[name="description"]').val(userInfo.description);
        };

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
            
            if(!confirm("정보를 수정하시겠습니까?")) return false;
            infoForm.submit();
        };
    </script>
    
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
        
    </body>

    </html>