<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Person View</h2>

이름 : ${person.name }<br/>
아이디 : ${person.id }<br/>
성별 : ${person.gender }<br/>
직업 : ${person.job }<br/><br/>

<input type="button" value="수정" onclick = "location.href='person_update.go?id=${person.id}'"/>
<input type="button" value="삭제" onclick = "location.href='person_delete.go?id=${person.id}'"/>
</body>
</html>