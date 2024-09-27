<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
	.outer {
		background-color: rgb(50, 100, 100);
		color: white;
		text-shadow: 0px 0px 60px #fff;
		width: 1000px;
		margin: auto;
		margin-top: 50px;
	}
	#enroll-form table {
		margin: auto;
		color: #fff;
	}
	#enroll-form input {
		margin: 5px;
		border-radius: 20px;
		border: 2px solid rgb(1, 68, 68);
		box-shadow: 0px 0px 10px rgb(1, 68, 68);
	}
	.update {
		background-color: rgb(204, 243, 243);
		box-shadow: 0px 0px 10px rgb(1, 68, 68);
		border: none;
		width: 100px;
		height: 30px;
		border-radius: 10px;
		font-weight: 900;
		cursor: pointer;
	}
	.update:hover{
		background-color: rgb(4, 54, 54);
		box-shadow: 0px 0px 10px rgb(1, 68, 68);
		color: #fff;
		transition: all 0.5s;
	}


</style>

</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
	<div class="outer">
		<br>
		<h2 align="center">마이페이지</h2>
		<form id="enroll-form" action="<%= contextPath %>/update.me" method="post">
			<table>
				<tr>
					<td>* 아이디</td>
					<td><input type="text" name="userId" maxlength="12" value="${ loginUser.userId }" readonly></td>
				</tr>
				<tr>
					<td>* 이름</td>
					<td><input type="text" name="userName" maxlength="6" value="${ loginUser.userName }" required></td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td><input type="tel" name="phone" value="${ loginUser.phone }"></td>
				</tr>
				<tr>
					<td>이메일</td>
					<td><input type="email" name="email" value="${ loginUser.email }"></td>
				</tr>
				<tr>
					<td>주소</td>
					<td><input type="text" name="address" value="${ loginUser.address }"></td>
				</tr>
				<tr>
					<td>취미</td>
					<td>
						<input type="checkbox" name="interest" id="baseball" value="야구">
						<label for="baseball">야구</label>

						<input type="checkbox" name="interest" id="cartoon" value="만화">
						<label for="cartoon">만화</label>
						
						<input type="checkbox" name="interest" id="soccer" value="축구">
						<label for="soccer">축구</label>

						<br>
						
						<input type="checkbox" name="interest" id="study" value="공부">
						<label for="study">공부</label>
						
						<input type="checkbox" name="interest" id="" value="게임">
						<label for="game">게임</label>
					</td>
				</tr>
			</table>

			<br><br>
			
			<div align="center">
				<button class="btn btn-sm btn-primary" type="submit">정보 수정</button>
				<button class="btn btn-sm btn-info" type="button" data-toggle="modal" data-target="#updatePwdModal">비밀번호 변경</button>
				<button class="btn btn-sm btn-danger" type="button" data-toggle="modal" data-target="#delMemberModal">회원 탈퇴</button>
			 </div>
	
			 <br /><br />
		  </form>
	   </div>
	   
	   <!-- The Modal -->
	   <div class="modal fade" id="updatePwdModal" tabindex="-1" aria-labelledby="updatePwdModalLabel" aria-hidden="true">
		 <div class="modal-dialog">
		   <div class="modal-content">
			<!-- 모달 헤더 부분 -->
			 <div class="modal-header">
			   <h1 class="modal-title fs-5" id="updatePwdModalLabel">비밀번호 변경</h1>
			   <button type="button" class="close" data-dismiss="modal" aria-label="Close">&times;</button>
			 </div>
			 <!-- 모달 바디 부분 -->
			 <div class="modal-body">
			   <form action="<%= contextPath %>/updatePwd.me" method="post">
				 <div class="mb-3">
				   <label for="recipient-name" class="col-form-label">현재 비밀번호 : </label>
				   <input type="password" class="form-control" id="userPwd" name="userPwd">
				 </div>

				 <div class="mb-3">
				   <label for="newPassword" class="col-form-label">변경할 비밀번호 : </label>
				   <input type="password" class="form-control" id="newPassword" name="newPassword">
				 </div>

				 <div class="mb-3">
					<label for="newPasswordCheck" class="col-form-label">변경할 비밀번호 확인 : </label>
					<input type="password" class="form-control" id="newPasswordCheck" name="newPasswordCheck">
				</div>

				<button class="btn btn-sm btn-primary" onclick="return pwdCheck()">비밀번호 변경</button>
			   </form>
			 </div>
			 <!-- 모달 푸터 부분 -->
			 <!-- <div class="modal-footer">
			   <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
			   <button type="button" class="btn btn-primary">Send message</button>
			 </div> -->
		   </div>
		 </div>
	   </div>

	   <!-- The Modal -->
	   <div class="modal fade" id="delMemberModal" tabindex="-1" aria-labelledby="delMemberModalLabel" aria-hidden="true">
		<div class="modal-dialog">
		  <div class="modal-content">
		   <!-- 모달 헤더 부분 -->
			<div class="modal-header">
			  <h2 class="modal-title fs-5" id="delMemberModalLabel">회원탈퇴</h2>
			  <button type="button" class="close" data-dismiss="modal" aria-label="Close">&times;</button>
			</div>
			<!-- 모달 바디 부분 -->
			<div class="modal-body">
			  <form action="<%= contextPath %>/delete.me" method="post">
				<div class="mb-3">
				  <p><b>탈퇴 후 <mark>복구 불가능</mark>합니다. <br> 그래도 탈퇴하시겠습니까?</b></p>
				</div>

				<div class="mb-3">
				  <label for="userPwd" class="col-form-label">비밀번호 : </label>
				  <input type="password" class="form-control" id="userPwd" name="userPwd" required>
				  <input type="hidden" class="form-control" id="userId" name="userId" value="${ loginUser.userId }">
				</div>

			   <button class="btn btn-sm btn-danger" onclick="return delMember()">탈퇴하기</button>
			  </form>
			</div>
			<!-- 모달 푸터 부분 -->
			<!-- <div class="modal-footer">
			  <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
			  <button type="button" class="btn btn-primary">Send message</button>
			</div> -->
		  </div>
		</div>
	  </div>

	<script>

		$(function() {
			const interest = "${ loginUser.interest }";
			const checkArr = $("input[name=interest]");

			// console.log(interest);
			// console.log(checkArr);

			for(let check of checkArr) {
				// check => js 방식으로 접근된 요소로 인식됨!
				if(interest.includes(check.value)){
					// check.prop("checked", true);
					check.checked = true;
				}
			}
			
			
		});

		function pwdCheck() {
			const pwd = document.querySelector("#updatePwdModal input[name=newPassword]").value;
			const pwdCheck = document.querySelector("#updatePwdModal input[name=newPasswordCheck]").value;
			const newPasswordForm = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*\W).{8,15}$/;
			
			if (pwd != pwdCheck) {
				alert("비밀번호와 비밀번호 확인 입력값이 다릅니다.");
				return false;
			}

			// if (!newPasswordForm.test($('#enroll-form input[name=newPassword]').val())) {
			// 	alert("비밀번호 양식이 적합하지 않습니다.");
			// 	return false;
			// }
		}
		



	</script>
</body>
</html>