<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="resources/js/jquery-3.6.0.min.js"></script>
</head>
<body>
	<div align="center">
		<h1>간편 회원가입</h1>
	</div>
	<div>
		<table id="joinTable" name="joinTable">
			<tr>
				<th width="200px">아이디</th>
				<td width="200px"><input type="text" id="inputId"
					name="inputId"></td>
				<td width="150px"><button type="button">중복체크</button></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td colspan="2"><input type="password" id="inputPassword"
					name="inputPassword"></td>
			</tr>
			<tr>
				<th>비밀번호 확인</th>
				<td colspan="2"><input type="password" id="inputPassword2"
					name="inputPassword2"></td>
			</tr>
			<tr>
				<th>이름</th>
				<td colspan="2"><input type="text" id="inputName"
					name="inputName"></td>
			</tr>
			<tr>
				<td colspan="3"><input type="reset" value="취소">
					<button type="button" onclick="memberJoin()">회원가입</button></td>
			</tr>
		</table>
	</div>
	<div>
		<form id="joinFrm" name="joinFrm">
			<input type="hidden" id="memberId" name="memberId"> <input
				type="hidden" id="memberPassword" name="memberPassword"> <input
				type="hidden" id="memberName" name="memberName">
		</form>

	</div>
	<script type="text/javascript">
		function formCheck() {
			if ($("#memberId").val() == "") {
				alert("아이디를 입력하세요.")
				$("#inputId").focus();
				return false;
			}
			if ($("#memberPassword").val() == "") {
				alert("비밀번호를 입력하세요.")
				$("#inputPassword").focus();
				return false;
			}
			if ($("#memberName").val() == "") {
				alert("이름을 입력하세요.")
				$("#inputName").focus();
				return false;
			}
			console.log($("#memberName").val());
			return true;
		}
		function IdCheck() {
            //나중에 해보기...
		}

		//회원가입폼에서 정보 넘기기
		function memberJoin() {
			let inputId = $("#inputId").val();
			let inputPassword = $("#inputPassword").val();
			let inputName = $("#inputName").val();

			//값 담기
			$("#memberId").val(inputId);
			$("#memberPassword").val(inputPassword);
			$("#memberName").val(inputName);
			
			//이거 안됨...
		    formcheck();
		    
			//값 넘기기
			$("#joinFrm").attr("action", "memberInsert.do");
			$("#joinFrm").submit();
		}
	</script>
</body>
</html>