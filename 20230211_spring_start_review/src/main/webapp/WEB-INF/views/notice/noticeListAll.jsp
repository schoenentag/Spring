<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- CSS only -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<title>공지사항 전체 목록</title>
</head>
<body>
    <h4>공지사항</h4> <br>

	<!--  vo 객체의 이름과 동일 -->
	<c:forEach items="${list}" var="l">
    <table class="table">
        <tr>
            <th>글번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>날짜<th>
            <th>조회수<th>
        </tr>
        <tr>
            <td>${l.noticeId}</td>
            <td onclick="location.href='/prj/noticeListOne.do?noticeId=<c:out value="${l.noticeId}" />'" style="cursor:pointer;">${l.noticeTitle}</td>
            <td>${l.noticeWriter}</td>
            <td><fmt:formatDate value="${l.noticeDate}" pattern="yyyy/MM/dd"/></td>
            <td>${l.noticeHit}</td>
        </tr>
    </table>
    </c:forEach>
    
    <select id="nSearch" name="nSearch">
        <option value="">== 선택 ==</option>
        <option value="memberId">제목</option>
        <option value="memberName">제목+내용</option>
        <option value="memberAuthor">작성자</option>
    </select>
    <input type="text" id="temp" name="temp" size="10" >

<script type="text/javascript">

    /* function noticeSec(noticeId){
    	location.href='/prj/noticeListOne.do?noticeId='+ noticeId;
    } */
    

</script>
</body>
</html>