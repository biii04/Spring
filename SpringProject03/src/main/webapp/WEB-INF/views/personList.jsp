<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Person List(${count})</h2>
<c:forEach items="${personlist }" var="person">  <!-- homecontroller의 전체보기 personlist와 연결 -->
이름 : <a href = "view?id=${person.id }">${person.name }</a><br/>
아이디 : ${person.id }<br/>
성별 : ${person.gender }<br/>
직업 : ${person.job }<br/><br/>
</c:forEach>
</body>
</html>