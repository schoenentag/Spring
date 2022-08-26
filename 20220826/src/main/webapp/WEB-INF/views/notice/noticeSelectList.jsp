<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>noticeSelectList</title>
<script src="resources/js/jquery-3.6.0.min.js"></script>
</head>
<style>
table {
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
	width: 200px;
}
</style>
<body>
	<div>
		<h1>공지사항 목록</h1>
	</div>
	<div>
		<table>
			<tr>
				<td width="100"><select id="key" name="key">
						<option value="1">제목</option>
						<option value="2">작성자</option>
						<option value="3">내용</option>
				</select></td>
				<td width="100"><input type="text" id="val" name="val"></td>
				<td width="100">
					<button type="button" onclick="searchCall()">검색</button>
				</td>
				<td width="100">
					<button type="button" onclick="location.href='noticeForm.do'">글쓰기</button>
				</td>
			</tr>
		</table>
	</div>

	<div>
		<table id="tb" >
			<thead>
				<tr>
					<th>게시글번호</th>
					<th>작성자</th>
					<th>제목</th>
					<th>첨부파일</th>
					<th>작성일자</th>
					<th>조회수</th>
				</tr>
			</thead>
			<tbody name = "list">
				<c:if test="${empty notices}">
					<tr>
						<td colspan="6">게시글이 존재하지 않습니다.</td>
					</tr>
				</c:if>
				<c:forEach items="${notices}" var="N">
					<tr onclick="noticeCall(${N.NOTICE_ID})">
						<td>${N.NOTICE_ID}</td>
						<td>${N.NOTICE_WRITER}</td>
						<td>${N.NOTICE_TITLE}</td>
						<td>${N.NOTICE_ATTACH}</td>
						<td>${N.NOTICE_DATE}</td>
						<td>${N.NOTICE_HIT}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br>
	</div>

	<div>
		<form id="frm" method="post">
			<input type="hidden" id="noticeId" name="noticeId">
		</form>
	</div>

	<script type="text/javascript">
    
  function noticeCall(id){
	  document.getElementById("noticeId").value = id
	  frm.action="noticeSelect.do";
	  frm.submit();
  }
  
  /*  자바스크립트로 ajax 처리
     function searchCall(){ //ajax처리
	  let key = document.getElementById('key').value;
      let val = document.getElementById('val').value; 
      fetch("ajaxSearch.do",{
         method : 'post',
         headers: { 'Content-Type' :'application/x-www-form-urlencoded',}, 
         redirect : 'follow',
         referrer : 'no-referrer',
         body : "key="+key+"&val="+val 
      }).then(response => response.json())
        .then((data)=> console.log(data)); //html convert method
  } 
        //json형태로 값을 전달할 때
        headers: { 'Content-Type' :'application/json',},
        body:JSON.stringify({"key":key, "val":val}})
        */
  
  // Jquery ajax 처리
  function searchCall(){
	  let key = $("#key").val();
	  let val = $("#val").val();
	  
	  $.ajax({
		  url: "ajaxSearch.do",
	      type: "post",
	      data: {"key":key, "val":val},
	      dataType: "json",
	      success: function(response){
	    	  htmlView(response);
	      },
	      error: function(){
	    	  console.log("실패했습니다.")
	      }
	  })
  }
  
  function htmlView(response){
	  $("[name='list']").remove(); // 기존 tbody 삭제
      let tbody = $("<tbody name='list' />"); // 검색했을때 나올 tbody 새로 생성
      $.each(response, function(index, item) {
         let row = $("<tr />").append($("<td />").text(item.noticeId),
                                $("<td />").text(item.noticeWriter),
                                $("<td />").text(item.noticeTitle),   
                                $("<td />").text(item.noticeAttach),
                                $("<td />").text(item.noticeDate),
                                $("<td />").text(item.noticeHit)
         )
         tbody.append(row);
      })
      $("#tb").append(tbody);
   }
</script>

</body>
</html>