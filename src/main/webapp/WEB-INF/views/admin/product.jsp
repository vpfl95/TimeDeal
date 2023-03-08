<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/library.jsp"></c:import>
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	<h1>상품</h1>
    <a href="/admin/members">멤버리스트</a>
    <a href="/admin/product">내가 등록한 상품</a>
    <a href="/product/add">상품 등록</a>
    <div id="wrapper">
        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">
                <!-- Begin Page Content -->
                <div class="container-fluid">
                    <table class="table">
                        <tr>
                            <th>상품번호</th>
                            <th>상품이름</th>
                            <th>재고</th>
                            <th>시작 시간</th>
                            <th>끝 시간</th>
                        </tr>
                        <c:forEach items="${list}" var="productVO">
                            <tr>
                                <td style="display:table-cell;vertical-align:middle;">${productVO.itemNum}</td>
                                <td style="display:table-cell;vertical-align:middle;">${productVO.itemName}</td>
                                <td style="display:table-cell;vertical-align:middle;">${productVO.ea}</td>
                                <td style="display:table-cell;vertical-align:middle;"><fmt:formatDate pattern="HH:mm" value="${productVO.startTime}"/></td>
                                <td style="display:table-cell;vertical-align:middle;"><fmt:formatDate pattern="HH:mm" value="${productVO.endTime}"/></td>
                            </tr>
                        </c:forEach>

                    </table>
                    
                  
                </div>
                <!-- /.container-fluid -->
            </div>
            <!-- End of Main Content -->
        </div>
        <!-- End of Content Wrapper -->
    </div>
    <!-- End of Page Wrapper -->

</body>
</html>