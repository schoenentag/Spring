<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>noticeSelectList</title>
</head>
<style>
table {
    width: 800px;
    text-align: center;
    border: 1px solid #fff;
    border-spacing: 1px;
    font-family: 'Cairo', sans-serif;
  margin: auto;
}

table td {
    padding: 10px;
    background-color: #eee;
}

table th {
    background-color: #333;
    color: #fff;
    padding: 10px;
}
</style>
<body>
	<c:forEach items="${notices}" var="n">
		<!-- 넘어오는 컬럼명 그대로 대문자로 써야함 -->
		<table>
			<tr>
				<th width="100px">게시글번호</th>
				<td width="150px">${n.NOTICE_ID}</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>${n.NOTICE_WRITER}</td>
			</tr>
			<tr>
				<th>제목</th>
				<td>${n.NOTICE_TITLE}</td>
			</tr>
			<tr>
				<th>첨부파일명</th>
				<td>${n.NOTICE_ATTACH}</td>
			</tr>
			<tr>
				<th>첨부파일위치</th>
				<td>${n.NOTICE_ATTACH_DIR}</td>
			</tr>
		</table>
		<br>
	</c:forEach>
</body>
</html>