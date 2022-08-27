<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center"><h1>MEMBER LIST</h1></div>
	<div>
		<table>
			<thead>
			<tr>
			<th width="150"> 회원 아이디 </th>
			<th width="100"> 회원 이름 </th>
			<th width="80"> 권한 </th>
			</tr>
			</thead>
			<tbody>
				<c:forEach items="${members}" var="m">
					<td>${m.memberId}</td>
					<td>${m.memberName}</td>
					<td>${m.memberAuthor}</td>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>