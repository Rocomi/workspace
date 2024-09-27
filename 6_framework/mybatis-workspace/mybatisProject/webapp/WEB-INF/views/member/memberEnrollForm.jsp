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
	.join {
		background-color: rgb(204, 243, 243);
		box-shadow: 0px 0px 10px rgb(1, 68, 68);
		border: none;
		width: 100px;
		height: 30px;
		border-radius: 10px;
		font-weight: 900;
		cursor: pointer;
	}
	.join:hover{
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
		<h2 align="center">회원가입</h2>
		<form id="enroll-form" action="<%= contextPath %>/insert.me" method="post">
			<table>
				<tr>
					<td>* 아이디</td>
					<td><input type="text" name="userId" maxlength="12" placeholder="아이디를 입력하세요" required></td>
					<td><input type="button" value="중복체크" onclick="idCheck();"></td>
				</tr>
				<tr>
					<td>* 비밀번호</td>
					<td><input type="password" name="userPwd" maxlength="15" required></td>
				</tr>
				<tr>
					<td>* 비밀번호 확인</td>
					<td><input type="password" name="userPwdCheck" maxlength="15" required></td>
				</tr>
				<tr>
					<td>* 이름</td>
					<td><input type="text" name="userName" maxlength="6" required></td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td><input type="tel" name="phone" placeholder="- 포함해서 입력"></td>
				</tr>
				<tr>
					<td>이메일</td>
					<td><input type="email" name="email"></td>
				</tr>
				<tr>
					<td>주소</td>
					<td><input type="text" name="address"></td>
				</tr>
				<tr>
					<td>생년월일</td>
					<td><input type="text" name="birthday" placeholder="ex)990101"></td>
				</tr>
				<tr>
					<td>성별</td>
					<td>
						<label for="man">남자</label>
						<input type="radio" name="gender" id="man" value="M">
						<label for="woman">여자</label>
						<input type="radio" name="gender" id="woman" value="F">
					</td>
				</tr>
			</table>

			<br><br>
			
			<div align="center">
				<button class="join" type="submit" onclick="return joinCheck();" disabled>회원가입</button>
				<button class="join" type="reset" onclick="resetAll();">초기화</button>
			</div>
			<div class="msgUserCheck" align="center" style="color: rgb(255, 35, 35); font-weight: 900; text-shadow: 0px 0px 30px #fff; height: 0px;">
			</div>
			<br><br>
		</form>
	</div>

	<script>
		function joinCheck() {
			const pwd = document.querySelector("#enroll-form input[name=userPwd]").value;
			const pwdCheck = document.querySelector("#enroll-form input[name=userPwdCheck]").value;
			const userPwdForm = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*\W).{8,15}$/;
			const userNameForm = /^[가-힣]{2,7}$/;
			
			if (pwd != pwdCheck) {
				alert("비밀번호와 비밀번호 확인 입력값이 다릅니다.");
				return false;
			}

			if (!userPwdForm.test($('#enroll-form input[name=userPwd]').val())) {
				alert("비밀번호 양식이 적합하지 않습니다.");
				return false;
			}

			if (!userNameForm.test($('#enroll-form input[name=userName]').val())) {
				alert("이름 양식이 적합하지 않습니다.");
				return false;
			}
		}

		function idCheck() {
			// 중복체크 버튼 클릭 시 사용자가 입력한 아이디 값을 서버로 보내서
			// 중복되는 데이터가 있는지 조회한 후에 결과를 받을 것임!

			// (1) 사용 가능 => 사용 가능합니다. 메시지 출력, 회원가입 버튼을 활성화\
			// (2) 사용 불가능 => 사용할 수 없는 아이디입니다. 메시지 출력, 다시 입력할 수 있도록 유도

			const userId = $("#enroll-form input[name=userId]").val();

			console.log("userId: " + userId);

			console.log("*** ajax 요청 전***");

			$.ajax({
				url:'idCheck.me',
				type: 'get',
				data: { userId: userId },
				success: function(result) {
					// 아이디를 입력하지 않았을 때
					if(userId === "") {
						alert("아이디를 입력하세요!")
					} else {
						// 아이디 형식 
						const userIdForm = /^(?=.*[a-z])(?=.*[0-9])((?=.*-)|(?=.*_)).{5,20}$/;

						// 아이디 형식이 맞지 않을때
						if (!userIdForm.test(userId)) {
							alert("아이디 형식이 부적합합니다")

						// 아이디 형식이 적합할 경우 중복 확인
						} else { 

							// result ==> 중복된 아이디가 있을 경우 ("NNN"), 없을 경우 ("NNY")
							if(result == 'NNN'){
								alert("사용할 수 없는 아이디입니다.");
								$("#enroll-form input[name=userId]").val("");
								$("#enroll-form input[name=userId]").focus();
							} else if(result == 'NNY') {
								const yn = confirm("사용 가능합니다. 사용하시겠습니까?");
								if(yn){
									$("#enroll-form input[name=userId]").attr("readonly", true);
									$("button[type=submit]").removeAttr("disabled");
									$("input[type=button]").attr("disabled",true);
								} else {
									$("#enroll-form input[name=userId]").focus();
								};
							};
						};
					};
				},
				error: function(err) {
					console.log(err);
				}
			});	
		}

		function resetAll() {
			$("#enroll-form input[name=userId]").attr("readonly", false);
			$("button[type=submit]").attr("disabled", true);
			$("input[type=button]").attr("disabled", false);
		}

		// 아이디 형식 확인
		$(function() {
			$('#enroll-form input[name=userId]').keyup(function() {
				
				const userid = $(this).val();
				const userIdForm = /^(?=.*[a-z])(?=.*[0-9])((?=.*-)|(?=.*_)).{5,12}$/;

				if (!userIdForm.test(userid)) {
					$(".msgUserCheck").html("5~12자의 영문 소문자, 숫자와 특수기호(_),(-) 포함");
				} else {
					$(".msgUserCheck").html("");
				}
				
            });
        })

		// 비밀번호 형식 확인
		$(function() {
			$('#enroll-form input[name=userPwd]').keyup(function() {
				
				const userPwd = $(this).val();
				const userPwdForm = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*\W).{8,15}$/;

				if (!userPwdForm.test(userPwd)) {
					$(".msgUserCheck").html("8~15자의 영문 대/소문자, 숫자와 특수문자 포함");
				} else {
					$(".msgUserCheck").html("");
				}
				
            });
        })

		// 비밀번호 확인 메세지
		$(function() {
			$('#enroll-form input[name=userPwdCheck]').keyup(function() {
				
				const userPwd = $('#enroll-form input[name=userPwd]').val();
				const userPwdCheck = $(this).val();

				if (userPwd !== userPwdCheck) {
					$(".msgUserCheck").html("비밀번호와 일치하지 않습니다.");
				} else {
					$(".msgUserCheck").html("");
				}
				
            });
        })

		$(function() {
			$('#enroll-form input[name=userName]').keyup(function() {
				
				const userName = $(this).val();
				const userNameForm = /^[가-힣]{2,6}$/;

				if (!userNameForm.test(userName)) {
					$(".msgUserCheck").html("이름을 확인해주세요");
				} else {
					$(".msgUserCheck").html("");
				}
				
            });
        })
	</script>
</body>
</html>