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
    <table class="table">
        <tr>
            <th>글번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>날짜<th>
            <th>조회수<th>
        </tr>
		<c:forEach items="${list}" var="l">
	        <tr>
		            <td>${l.noticeId}</td>
		            <td onclick="location.href='/prj/noticeListOne.do?noticeId=<c:out value="${l.noticeId}" />'" style="cursor:pointer;">${l.noticeTitle}</td>
		            <td>${l.noticeWriter}</td>
		            <td><fmt:formatDate value="${l.noticeDate}" pattern="yyyy/MM/dd"/></td>
		            <td>${l.noticeHit}</td>
	        </tr>
    	</c:forEach>
    </table>
    <div>
    <button onclick="location.href='noticeInsertForm.do'">글쓰기</button>
    </div>
    
    <div id="searchArea">
	    <select id="nSearch" name="nSearch">
	        <option>== 선택 ==</option>
	        <option value="T">제목</option>
	        <option value="TS">제목+내용</option>
	        <option value="W">작성자</option>
	    </select>
	    <input type="text" id="keyword" name="keyword" size="10" >
	    <button id="ajaxSearchCall">검색</button>
    </div>

<script type="text/javascript">
    window.onload = function() {
    	
    	var httpRequest;
    	
    	//검색 버튼 클릭
    	document.getElementById("ajaxSearchCall").addEventListener('click',()=>{
    	    //검색 타입과 키워드 가져오기 
    		let inputType = document.getElementById('nSearch').value;
    	    let inputKeyword = document.getElementById("keyword").value;
    	    
    	    //통신에 사용될 XMLHttpRequest 객체 정의
    	    httpRequest = new XMLHttpRequest();
    	    
    	    //httpRequest의 readyState가 변화했을때 함수 실행
    	    httpRequest.onreadystatechange = () => {
    	    	//readState가 Done이고 응답값이 200일때 받아온 response로 뿌려줌
    	    	if (httpRequest.readyState === XMLHttpRequest.DONE) {
    	    		
    	    		if (httpRequest.status === 200) {
    	    			var result = httpRequest.response;
    	    			console.log(result);
	    	    		console.log('일단 성공');
	    	    	} else{
	    	    		alert('Request Error!');
	    	    	  }
	    	    }
    	    };
    	    
    	    //get 방식으로 parameter 요청
    	    httpRequest.open('GET', '/prj/ajaxNoticeSearch.do?inputType='+inputType+'&&inputKeyword='+inputKeyword);
    	    httpRequest.responseType = "json";
    	    httpRequest.send();
    	});
    }
    
    /*function ajaxSearchCall(){
    	console.log("클릭!")
    	
    	
    	console.log("secType :", secType )
    	console.log("inputKeyword :", inputKeyword )
    	
    	let getData = () => {
    		
    		let xhr = new XMlhttpRequest;
    		xhr.open('POST', '/ajaxNoticeSearch.do', true);
    		xhr.onload = (){
    			if(xhr.status == 200){
    				let result = xhr.response;
    				return result;
    			} else {
    				alert("ERROR LOADING FILE!" + this.status);
    			}
    		};
    		xhr.send();
    		
    	}
    function showData = () => {
    	let result = getData();
    	console.log(result);
    }*/
    	
    	/*fetch('/ajaxNoticeSearch.do',{
    		method : "post",
    		headers: {
    			"Content-type" : "application/json",
    		},
    		body : JSON.stringify({
    			type : secType,
    			keyword : inputKeyword,
    		}),
    	})
    	.then((res) => res.json())
    	.then((data) => console.log(data))
    	.catch(function(err){
    		console.log('failed',err);
    	})
    }*/


</script>
</body>
</html>