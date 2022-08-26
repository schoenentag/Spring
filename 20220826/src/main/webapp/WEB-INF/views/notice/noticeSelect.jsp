<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Notice Select</title>
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
</head>
<body>
	<table border="1">
		<tr>
			<th width="100px">게시글번호</th>
			<td width="150px">${n.noticeId}</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${n.noticeWriter}</td>
		</tr>
		<tr>
			<th>작성날짜</th>
			<td>${n.noticeDate}</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${n.noticeTitle}</td>
		</tr>
		<tr>
			<th>조회수</th>
			<td>${n.noticeHit}</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>${n.noticeSubject}</td>
		</tr>
	</table><br>
</body>
</html>