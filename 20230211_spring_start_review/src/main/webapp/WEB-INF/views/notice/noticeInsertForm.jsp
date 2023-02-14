<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <form id="frm" method="post">
	    <table class="table">
	        <input type="hidden" id="noticeId" name="noticeId" value="2">
	        <input type="hidden" id="noticeWriter" name="noticeWriter" value="temp">
	        <tr>
	            <th>제목</th>
	            <td><input type="text" size="30" id="noticeTitle" name="noticeTitle"></td>
	        </tr>
	        <tr>
	            <th>내용</th>
	            <td><textarea style="resize: both;" id="noticeSubject" name="noticeSubject"></textarea></td>
	        </tr>
	        <tr> 
	            <th>첨부파일</th>
	            <!-- <td><input type="file" id="noticeAttach" name="noticeAttach"></td> -->
	        </tr>
	    </table>
	    <button type="button" onclick="insertCall()">등록</button>
	    <button type="reset">초기화</button>
    </form>
    
<script type="text/javascript">

    function insertCall(){
    	let insertText = confirm("등록하시겠습니까?");
    	if(insertText){
    		alert("글이 등록되었습니다.")
    		frm.action = "noticeInsert.do";
    		frm.submit();
    	}else{
    		alert("등록을 취소하였습니다.")
    	}
    }


</script>

</body>


</html>