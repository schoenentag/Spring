<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원목록</h1>

<!-- VO객체의 이름과 동일! -->
<c:forEach items="${members }" var="m">
    ${m.member_id } : ${m.member_password } : ${m.member_name } : ${m.member_author }</c:forEach>

</body>
</html>