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
	<h1>상품 수정</h1>
    <form action="./${productVO.itemNum}" method="post" enctype="multipart/form-data">
        <input type="hidden" name="_method" value="PUT">
        상품이름 <input type="text" name="itemName" value="${productVO.itemName}">
        <div id="fileBox"></div>
        <div id="image">
            <div>
                <label id="fileAdd" class="border border-success rounded-3" style="width: 200px; height: 200px; color: green; text-align: center;">
                    <div style="position : relative; margin-right: 20px;">
                        <img src="/file/product/${productVO.fileVOs[0].fileName}" style="width: 200px; height: 200px; border-radius: 15px;">
                        <i class="del fa-solid fa-xmark" data-fileNum="${productVO.fileVOs[0].fileNum}" style="position: absolute; right:0; color:limegreen"></i>
                    </div>
                </label>
            </div>
        </div>
       <h1>${productVO.fileVOs[0].fileNum}</h1>

        <div>
            재고 <input type="text" name="ea" value="${productVO.ea}">
            시작 시간 <input type="datetime-local" name="startTime" value="${productVO.startTime}">
            끝 시간 <input type="datetime-local" name="endTime" value="${productVO.endTime}">
            <input type="test" name="id" value="${member}">
            

        </div>
        <button>수정</button>
    </form>

    <script src="/js/product/update.js"></script>
</body>
</html>