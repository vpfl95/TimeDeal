<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<c:import url="../template/library.jsp"></c:import>
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	<h1>상품 등록</h1>
    <form action="/product" method="post" enctype="multipart/form-data">
        상품이름 <input type="text" name="itemName">
        <div id="fileBox">
        </div> 
        이미지<input  type="file" name="files" id="files" class="files form-control form-control-sm" onchange="setThumbnail(event)">
        재고 <input type="text" name="ea">
        시작 시간 <input type="datetime-local" name="startTime">
        끝 시간 <input type="datetime-local" name="endTime">
        <input type="test" name="id" value="${member}">
        <button>등록</button>
    </form>
    <button id="asd">등록</button>

    <script src="/js/product/product.js"></script>
</body>
</html>