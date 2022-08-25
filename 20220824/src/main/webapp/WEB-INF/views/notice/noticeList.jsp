<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>공지목록</h1>

	<!-- VO객체의 이름과 동일! -->
	<c:forEach items="${notices }" var="n">
	<table border="1" id="noticeTable" name="noticeTable">
		<thead>
			<tr>
				<th>게시판번호</th>
				<th>작성자</th>
				<th>제목</th>
				<th>내용</th>
				<th>작성일자</th>
				<th>조회수</th>
				<th>첨부파일명</th>
				<th>첨부파일위치</th>
			</tr>
		</thead>
		<tbody id="tbody" name="tbody">
		<tr>
		<td>${n.notice_id }</td>
		<td>${n.notice_writer }</td>
		<td>${n.notice_title }</td>
		<td>${n.notice_subject }</td>
		<td>${n.notice_date }</td>
		<td>${n.notice_hit }</td>
		<td>${n.notice_attach }</td>
		<td>${n.notice_attach_dir }</td>
		</tr>
		</tbody>
	</table>
		
	</c:forEach>
	<a href="noticeForm.do"> 등록하러가기</a>
</body>
</html>