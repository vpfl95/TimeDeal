<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>

<div class="d-flex justify-content-end mt-3" style="width:85%">
    <div>
        <c:if test="${empty member}">
            <a href="/member/login">로그인</a>
            <span style="padding: 0px 9px 0px 14px">|</span>
            <a href="/member/join">회원가입</a>
        </c:if>
        <c:if test="${not empty member}">
            <c:if test="${not empty memberRole}">
                <a href="/member/mypage">마이페이지</a>
            </c:if>
            <c:if test="${not empty adminRole}">
                <a href="/member/admin">관리자</a>
            </c:if>
            <!-- <a href="/member/mypage">마이페이지</a> -->
            <span style="padding: 0px 9px 0px 14px">|</span>
            <a href="/member/logout">로그아웃</a>
        </c:if>
    </div>

</div>

