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
            <span>성명</span>
            <input type="text" name="userName" maxlength="8" minlength="2"/><br/>

            <span>닉네임</span>
            <input type="text" name="nickName"/ maxlength="8" minlength="2"><br/>

            <span>아이디</span>
            <input type="text" name="id"/><br/>

            <span>패스워드</span>
            <input type="password" name="password" minlength="8" maxlength="12"/><br/>

            <span>패스워드 확인</span>
            <input type="password" name="confirmPassword"/><br/>

            <span>이메일</span>
            <input type="email" name="email"/><br/>

            <span>전화번호</span>
            <input type="tel" name="phone"/><br/>

            <span>홈페이지</span>
            <input type="text" name="hoempage"><br/>

            <span>자기소개</span>
            <textarea name="description" cols="30" rows="10"></textarea>

            <button id="submit_btn" type="button">가입하기</button>
        </form>
    </div>

    <script>
        let submitBtn;
        
        window.addEventListener("DOMContentLoaded", function() {
            submitBtn = document.querySelector('#submit_btn');
            setEvent();
        });

        function setEvent() {
            submitBtn.addEventListener("click", function() {
                validateForm();
            });
        };

        function validateForm() {
            if(!validatePassword()) {
                alert("Passwords are not correct each other!");
                return false;
            }

            submitBtn.submit();
        };

        function validatePassword() {
            const password = document.getElementsByName("password")[0];
            const confirmPassword = document.getElementsByName("confirmPassword")[0];

            return password === confirmPassword;
        };

    </script>
</body>
</html>