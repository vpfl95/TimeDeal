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
    <h1>회원가입</h1>
    <form action="join" method="post">
        아이디 <input type="text" name="id" autocomplete="false">
        비밀번호 <input type="password" name="pw" autocomplete="new-password">
        이름 <input type="text" name="name">
        <button>가입하기</button>
    </form>
	
</body>
</html>