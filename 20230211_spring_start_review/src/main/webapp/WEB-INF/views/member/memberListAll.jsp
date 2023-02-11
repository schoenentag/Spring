<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 전체 목록</title>
</head>
<body>
<h3> 회원 전체 목록 </h3>
<div>
    <label>회원검색</label> <br>
    <select id="mSearch" name="mSearch">
        <option value="">== 선택 ==</option>
        <option value="memberId">아이디</option>
        <option value="memberName">이름</option>
        <option value="memberAuthor">등급</option>
    </select>
    <input type="text" id="temp" name="temp" size="10" >
</div>

<!--  vo 객체의 이름과 동일 -->
<c:forEach items="${member}" var="m">
    <table>
        <tr>
            <th>아이디</th>
            <th>이름</th>
            <th>등급</th>
            <th>Blind<th>
        </tr>
        <tr>
            <td>${m.memberId}</td>
            <td>${m.memberName}</td>
            <td>${m.memberAuthor}</td>
            <td><input type="button" value="Blind"></td>
        </tr>
    </table>
    </c:forEach>
</body>
</html>