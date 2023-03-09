<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/index.css" />
<c:import url="./template/library.jsp"></c:import>
</head>
<body>
	<c:import url="./template/header.jsp"></c:import>
    <div id="wrapper">
        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">
                <!-- Begin Page Content -->
                <div class="container-fluid">
                    <div class="top_wrap" style="background-color:#9d9acb;">
                        <div class="top_inner mt-4">
                            <h2 class="md_visual"><img width="100%" src="https://cdn.011st.com/11dims/quality/75/11src/browsing/banner/2018/11/08/20829/201811082217080210_10175540_1.jpg"  alt="타임딜"></h2>
                        </div>
                    </div>
                </div>
                <section class="container" style="width: 75%">
                    <div class="container-fluid mt-3">
                        <c:forEach items="${list}" var="item">
                            <div class="top_wrap mt-5" style="border: 1px solid #dadada;  height: 350px;" onclick="location.href='/product/${item.itemNum}'">                                <div class="prd_box d-flex mt-4" style="justify-content: space-evenly">
                                    <div class="prd_img">
                                        <img src="/file/product/${item.fileVOs[0].fileName}" style="width: 300px; height: 300px; border-radius: 15px;"></a> 
                                    </div>
                                    <div class="prd_info d-flex flex-column" style="width: 370px;">
                                        <div class="deal">
                                            <em class="tag">
                                                <span class="tit" style="color: white;">쇼킹 타임딜</span>
                                                <span class="time" data-timedealendtime="1678283999000" data-timedealbgntime="1678269600000" aria-label="남은 시간 00시간 40분 11초">00:40:11</span>
                                            </em>
                                            <span class="num"><em>${item.ea}개</em> 남음</span>
                                        </div>
                                        <p class="name">${item.itemName}</p>
                                    </div>
                         
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </section>
                <!-- /.container-fluid -->
            </div>
            <!-- End of Main Content -->
        </div>
        <!-- End of Content Wrapper -->
    </div>
    <!-- End of Page Wrapper -->
</body>
</html>