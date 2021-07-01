<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>회원 정보</title>
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

            setEvent();
        };

        function setEvent() {
            $('#modify_btn').on("click", function() {
                if(confirm("개인정보를 수정하시겠습니까?")) {
                    location.assign("${pageContext.request.contextPath}/user/modify");
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
    </script>
    <body>
        <div id="btn_container">
            <button id="home_btn" onclick="location.assign('${pageContext.request.contextPath}/main')">홈으로</button>
        </div>
        <div id="userInfo_container">
            <label>아이디:<input type="text" name="id" readonly="true"></label><br />
            <label>이름:<input type="text" name="userName" readonly="true"></label><br />
            <label>닉네임:</label><input type="text" name="nickName" readonly="true"><br />
            <label>이메일:</label><input type="text" name="email" readonly="true"><br />
            <label>연락처:</label><input type="text" name="phone" readonly="true"><br />
            <label>홈페이지:</label><input type="text" name="homepage" readonly="true"><br />
            <label>소개:</label><br /><textarea name="description" id="" cols="30" rows="10" readonly="true"></textarea>
            <button id="modify_btn" type="button">수정하기</button>
        </div>
    </body>
    </html>