<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Todo List</h2>

<ul>
    <c:forEach items="${dtoList}" var="dto">
        <li>
            <span><a href="/todo/read?tno=${dto.tno}">${dto.tno}</a></span>
            <span>${dto.name}</span>
            <span>이름 :${dto.id}</span>
            <span>아이디 :${dto.age}</span>
            <span>패스워드 : ${dto.password}</span>
            <span>
                <p>성별 : <c:if test = "${dto.gender == true}">남</c:if>
    <c:if test = "${dto.gender != true}">여</c:if></p>
            </span>
            <span>취미 : ${dto.hobbies}</span>
            <span>여행 가고 싶은 나라 : ${dto.travel}</span>
            <span>비고 : ${param.content}</span>
        </li>
    </c:forEach>
</ul>

<%--<p>이름 : ${param.name}</p>--%>
<%--<p>아이디 : ${param.id}</p>--%>
<%--<p>패스워드 : ${param.password}</p>--%>
<%--<p>연령 : ${param.age}</p>--%>
<%--<p>성별 : <c:if test = "${param.gender == true}">남</c:if>--%>
<%--    <c:if test = "${param.gender != true}">여</c:if></p>--%>
<%--<p>취미 : ${param.hobbies}</p>--%>
<%--<p>여행 가고 싶은 나라 : ${param.travel}</p>--%>
<%--<p>비고 : ${param.content}</p>--%>
</body>
</html>
