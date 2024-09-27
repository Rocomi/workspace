<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
 .wrap{
 	margin: 200px;
 	margin-top: 50px;
 	box-shadow: 10px 10px 20px black;
 	padding: 50px;
 }
</style>
</head>
<body>
	<div class="wrap">
	    <h1>피자 주문 내역</h1>
	    <h3>주문자 정보</h3>
	    <% 
	    	String userName = (String)request.getAttribute("userName");			
			String userTel = (String)request.getAttribute("userTel");				
			String address = (String)request.getAttribute("address");
			String ask = (String)request.getAttribute("ask");
			String pizza = (String)request.getAttribute("pizza");
			String[] topping = (String[])request.getAttribute("topping");
			String edge = (String)request.getAttribute("edge");
			String dow = (String)request.getAttribute("dow");
			String[] side = (String[])request.getAttribute("side");
			String[] beverage = (String[])request.getAttribute("beverage");
		%>
		
		주소 : <%= address %> <br>
		전화번호 : <%= userTel %> <br>
		요청사항 <br>
		<% if (ask == ""){out.println("없음");}else{out.println(ask);} %>
		
		<hr>
		<h3>주문 정보</h3>
		<%= pizza %> <br>
		엣지 : <%= edge %> <br>
		도우 : <%= dow %> <br><br>
		토핑 추가 항목
		<ul>
			<% if (topping == null){
				out.println("없음");
				}else{
					for(String t : topping) { %>
						<li><%= t %></li>
					<% } 
				}%>
		</ul>
		<br>
		사이드 선택
		<ul>
			<% if (side == null){out.println("없음");}
			else{
				for(String s : side) { %>
					<li><%= s %></li>
					<% } 
				}%>	
		</ul> 
		<br> 
		음료 선택
		<ul>
		<% if (beverage == null){out.println("없음");}
			else{
				for(String b : beverage) { %>
					<li><%= b %></li>
					<% } 
				}%>
		
		</ul> 
		<hr>
		<%= userName %> 님 <br>
		즐거운 식사 되세요!!!
	</div>
</body>
</html>