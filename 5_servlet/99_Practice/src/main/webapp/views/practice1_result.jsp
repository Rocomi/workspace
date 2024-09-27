<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>연습 (1) - 랜덤 숫자 뽑기 - 결과페이지</title>

<style>
	body {
		background-color: #000;
	}
	ol{
		margin: 60px;
	}
	ol>li {
		font-size: larger;
		font-weight: 900;
		color: #fff;
		text-shadow: 0px 0px 10px;
	}
	p {
		font-size: x-large;
		font-weight: 900;
		color: red;
		text-shadow: 0px 0px 10px;
		text-shadow: 0px 0px 20px orangered;
		text-shadow: 0px 0px 30px orange;
	}

</style>
</head>
<body>
	<%-- 1 ~ 45까지 랜덤 숫자 6개를 뽑아 출력하기 --%>
	
	<ol>
		<b><p>생성된 랜덤 번호!!(6개)</p></b> <br>
		<% for (int i =0; i<6 ; i++) {%>
			<li><%=(int)(Math.random()*45+1)%></li> <br>
		<% } %>
	</ol>

</body>
</html>