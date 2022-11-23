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
<h3>Person Mybatis List(${count })</h3>

<form action = "per_list">
	<select name="field">
		<option value="name">이름</option>
		<option value="jon">직업</option>
	</select>
	<input type = "text" name = "word">
	<input type = "submit" name = "검색">
</form>

<c:forEach items="${personlist }" var = "person">

이름 : <a href="view?id=${person.id}">${person.name }</a><br>
아이디 : ${person.id }<br/>
성별 : ${person.gender }<br/>
직업 : ${person.job }<br/><br/>
</c:forEach>
</body>
</html>