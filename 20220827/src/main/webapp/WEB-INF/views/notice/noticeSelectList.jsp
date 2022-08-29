<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 목록</title>
<script src="resources/js/jquery-3.6.0.min.js"></script>
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>


</head>
<body>
	<div align="center">
		<h1>공지사항 목록</h1>
	</div>

	<c:if test="${empty id  }">
		<div>
			<button type="button" onclick="location.href='memberLoginForm.do'">로그인</button>
		</div>
		<div>
			<button type="button" onclick="location.href='memberInsertForm.do'">회원가입</button>
		</div>
	</c:if>
	<c:if test="${not empty id  }">
		<div>${name}님</div>
		<div>
			<button type="button" onclick="">로그아웃</button>
		</div>
	</c:if>
	<br>

	<div>
		<select id="key" name="key">
			<option value="1">제목</option>
			<option value="2">내용</option>
			<option value="3">작성자</option>
		</select>
		<input type="text" id="val" name="val">
		<button type="button" onclick="searchCall()">검색</button>
	</div>

	<table class="table" >
		<thead>
			<tr>
				<th scope="col">글번호</th>
				<th scope="col">제목</th>
				<th scope="col">작성자</th>
				<th scope="col">날짜</th>
				<th scope="col">조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${notices }" var="N">
				<tr>
					<td scope="row">${N.NOTICE_ID }</td>
					<td>${N.NOTICE_TITLE}</td>
					<td>${N.NOTICE_WRITER}</td>
					<td>${N.NOTICE_DATE}</td>
					<td>${N.NOTICE_HIT}</td>
				</tr>
			</c:forEach>

			<c:if test="${empty notices} ">
				<tr>
					<td colspan="5" align="center">게시글이 없습니다.</td>
				</tr>
			</c:if>


		</tbody>
	</table>
	<!-- session의 author가 admin 또는 user일 경우 글쓰기 활성화 -->
	<c:if test="${not empty author  }">
		<div>
			<button type="button" onclick="location.href='noticeInsertForm.do'">글쓰기</button>
		</div>
	</c:if>

</body>
<script type="text/javascript">
function searchCall(){
	
 	let key =$("#key").val();
	let val =$("#val").val();
	
	$.ajax({
		url :'ajaxNoticeSearch.do',
		method:'post',
		data:{'key':key, 'val':val},
		dataType:'json',
		success: function(res){
			console.log(res);
		},
		error: function(err){
			console.log(err);
		}
	})
	/* .then((res) => res.json())
	.then((obj) => {
		console.log("성공!");
	}) */
}
	
</script>
</html>