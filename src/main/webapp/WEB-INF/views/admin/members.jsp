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
	<h1>멤버스</h1>
    <a href="/admin/members">멤버리스트</a>
    <a href="/admin/product">내가 등록한 상품</a>
    <div id="wrapper">
        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">
                <!-- Begin Page Content -->
                <div class="container-fluid">
                    <table class="table">
                        <tr>
                            <th>ID</th>
                            <th>이름</th>
                            <th>등급</th>
                        </tr>
                        <c:forEach items="${list}" var="memberVO">
                            <tr>
                                <td style="display:table-cell;vertical-align:middle;">${memberVO.id}</td>
                                <td style="display:table-cell;vertical-align:middle;">${memberVO.name}</td>
                                <td style="display:table-cell;vertical-align:middle;">${memberVO.role.roleName}</td>
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