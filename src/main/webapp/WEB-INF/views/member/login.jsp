<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>로그인</h1>
    <form action="login" method="post">
        <div>
            아이디 <input type="text" name="id">
            비밀번호 <input type="password" name="pw">
            <button>로그인</button>
        </div>

    </form>
	
</body>
</html>