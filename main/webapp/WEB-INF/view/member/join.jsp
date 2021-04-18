<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Join Member</title>
</head>
<body>
    <div>
        <form id="registForm" action="${pageContext.request.contextPath}/member/regist" method="POST">
            <div>
                <span>아이디</span>
                <input type="text" name="id">
            </div>
            <div>
                <span>패스워드</span>
                <input type="password" name="password">
            </div>
            <div>
                <span>이름</span>
                <input type="text" name="name">
            </div>
            <div>
                <span>이메일</span>
                <input type="text" name="email">
            </div>

            <button type="submit" onclick="checkValidation(); return false;">가입하기</button>
        </form>
    </div>
</body>
<script>
    function checkValidation() {
        let registForm = document.getElementById("registForm");

        let id = registForm.querySelector("input[name='id']");
        if(id.value === '') {
            alert("아이디를 입력해주세요.");
            id.focus();
            return false;
        }
        
        let password = registForm.querySelector("input[name='password']");
        if(password.value === '') {
            alert("패스워드를 입력해주세요.");
            password.focus();
            return false;
        }

        let name = registForm.querySelector("input[name='name']");
        if(name.value === '') {
            alert("이름을 입력해주세요.");
            name.focus();
            return false;
        }

        let email = registForm.querySelector("input[name='id']");
        if(email.value === '') {
            alert("이메일을 입력해주세요.");
            email.focus();
            return false;
        }

        registForm.submit();
    }
</script>
</html>