<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="resources/js/jquery-3.6.0.min.js"></script>
</head>
<body>
	<div align="center"><h1>로그인</h1></div>
	<div>
		<table>
			<tr>
				<th width="150px">아이디</th>
				<td width="200px"><input type="text" id="inputId"
					name="inputId"></td>
				<td width="300px" rowspan="2">
				<button type="button" onclick="loginCall()">로그인</button>&nbsp;
				<input type="reset" value="취소">
				</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" id="inputPassword"
					name="inputPassword"></td>
			</tr>

		</table>
	</div>
	<div>
		<!-- 데이터 숨겨서 값 넘기기 -->
		<form id="LoginFrm" action="memberLogin.do" method="post">
			<input type="hidden" id="memberId" name="memberId"> <input
				type="hidden" id="memberPassword" name="memberPassword">
		</form>
	</div>

	<script type="text/javascript">
		function loginCall(){
			let inputId = $("#inputId").val();
			let inputPassword = $("#inputPassword").val();
			
			$("#memberId").val(inputId);
			$("#memberPassword").val(inputPassword);

		    $("#LoginFrm").submit();
		}
	</script>
</body>
</html>