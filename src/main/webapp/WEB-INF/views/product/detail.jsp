<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/index.css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<c:import url="../template/library.jsp"></c:import>
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	<h1>상품 상세</h1>
    <h1>${productVO.itemName}</h1>
    <section class="container" style="width: 75%">
        <div class="container-fluid mt-3">
            <div class="top_wrap mt-5" style="border: 1px solid #dadada;  height: 350px;">                                
                <div class="prd_box d-flex mt-4" style="justify-content: space-evenly">
                    <div class="prd_img">
                        <img src="/file/product/${productVO.fileVOs[0].fileName}" style="width: 300px; height: 300px; border-radius: 15px;">
                    </div>
                    <div class="prd_info d-flex flex-column" style="width: 370px;">
                        <div class="deal">
                            <em class="tag">
                                <span class="tit" style="color: white;">쇼킹 타임딜</span>
                                <span class="time" data-timedealendtime="1678283999000" data-timedealbgntime="1678269600000" aria-label="남은 시간 00시간 40분 11초">00:40:11</span>
                            </em>
                            <span class="num"><em>${productVO.ea}개</em> 남음</span>
                        </div>
                        <p class="name">${productVO.itemName}</p>
                        <button class="btn btn-dark" data-id="${member}" data-itemNum="${productVO.itemNum}" type="button" onclick="buy(event)">구매하기</button>
                        <c:if test="${not empty adminRole}">
                            <div>
                                <button class="btn btn-success" type="button" onclick="location.href='/product/add/${productVO.itemNum}'">수정</button>
                                <button class="btn btn-primary" type="button" onclick="location.href='/product/${productVO.itemNum}'">삭제</button>
                            </div>
                        </c:if>
                    </div>
                </div>    
            </div>
        </div>
    </section>
</div>
<script>
    function buy(event){
        console.log("구매하기")
        let itemNum = $(event.target).attr("data-itemNum")
        let id = $(event.target).attr("data-id")
        console.log(itemNum)
        console.log(id)
        $.ajax({
            type:"POST",
            url:"/product/buy",
            data:{
                id:id,
                itemNum:itemNum
            },
            success:function(data){
            console.log(data)
            if(data==0){
                alert("이미 구매했습니다.")
            }else{
                alert("구매완료")
            }
            }

        })

    }

</script>
</body>
</html>