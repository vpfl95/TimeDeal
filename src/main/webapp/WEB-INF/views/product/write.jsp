<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/library.jsp"></c:import>
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	<h1>상품 등록</h1>
    <form action="write" method="post">
        상품이름 <input type="text" name="itemName">
        재고 <input type="text" name="ea">
        시작 시간 <input type="time" name="startTime">
        끝 시간 <input type="time" name="endTime">
        <input type="test" name="id" value="${member.id}">
        <button>등록</button>
    </form>
</body>
</html>