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
    <!-- 만약 글쓴이면 수정/삭제 가능 -->
    <div>
	    <button>수정</button>
	    <button onclick="nDeleteCall(${list.noticeId})">삭제</button>
    </div>
    <hr>
    <div>
	    <table id="comment">
	    	<tr>
	    		<th>아이디</th>
	    		<td><input type="text" size="15"></td>
	    		<td><input type="submit" value="댓글달기"></td>
	    	</tr>
	    </table>
    </div>
    <div>
    <table id="cList">
	    	<tr>
	    		<th>아이디</th>
	    		<td>댓글내용</td>
	    		<!-- 만약 댓글 단 본인이면 활성화 -->
	    		<td><input type="button" value="수정"></td>
	    		<td><input type="button" value="삭제"></td>
	    	</tr>
	    </table>
    </div>
<script type="text/javascript">
    
    function nDeleteCall(noticeId){
    	
    	let deleteText = confirm("삭제하시겠습니까?");
    	if(deleteText){
    		alert("글이 삭제되었습니다.")
    	    location.href='noticeDelete.do?noticeId='+ noticeId;
    	}else{
    		alert("삭제를 취소하였습니다.")
    	}
    }

</script>
    
</body>
</html>