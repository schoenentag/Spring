<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<title>공지사항 상세정보</title>
</head>
<body>
  <h4>글 상세조회</h4> <br>

    <table class="table">
        <tr>
            <th><c:out value="${list.noticeId}" /></th>
            <th><c:out value="${list.noticeTitle}" /></th>
            <th><fmt:formatDate value="${list.noticeDate}" pattern="yyyy/MM/dd"/></th>
        </tr>
        <tr>
            <td colspan='2'><c:out value="${list.noticeWriter}"/></td>
            <td><c:out value="${list.noticeHit}"/></td>
        </tr>
        <tr> 
            <td colspan='3'><c:out value="${list.noticeSubject}"/></td>
        </tr>
    </table>
    
</body>
</html>