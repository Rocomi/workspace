<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL 연산자</title>
</head>
<body>
	<h1>EL 연산자</h1>
	
	<h3>* 산술 연산</h3>
	- 기존 : 10000 + 10 = <b><%= (int)request.getAttribute("big") + (int)request.getAttribute("small") %></b>
	<br><br>
	
	- EL 방식 : <br>
	10000 + 10 = <b> ${ big + small } </b> <br>
	10000 - 10 = <b> ${ big - small } </b> <br>
	10000 * 10 = <b> ${ big * small } </b> <br>
	10000 / 10 = <b> ${ big / small } 또는 ${ big div small }</b> <br>
	10000 % 10 = <b> ${ big % small } 또는 ${ big mod small }</b> <br>
	
	<h3>* 대소비교 연산</h3>
	10000 &gt; 10 = <b>${ big > small } 또는 ${ big gt small }</b> <br>
	10000 &lt; 10 = <b>${ big < small } 또는 ${ big lt small }</b> <br>
	10000 &gt;= 10 = <b>${ big >= small } 또는 ${ big ge small }</b> <br>
	10000 &lt;= 10 = <b>${ big <= small } 또는 ${ big le small }</b> <br>
	
	<h3>* 동등비교 연산</h3>
	<!--  EL에서는 문자열 동등비교가 자바에서의 equals와 같이 동작됨! -->
	- s1과 s2의 값이 일치하는가? <b>${ s1 == s2 } 또는 ${ s1 eq s2 }</b> <br>
	- s2와 s4의 값이 일치하는가? <b>${ s2 == s4 } 또는 ${ s2 eq s4 }</b> <br>
	
	- s2와 s3의 값이 일치하지 않는가? <b>${ s2 != s3 } 또는 ${ s2 ne s3 }</b> <br>
	
	- small에 담긴 값이 10입니까? <b>${ small == 10 } 또는 ${ small eq 10 }</b> <br>
	
	<!-- EL에서는 문자열 리터럴 표현 시 작은따옴표, 큰따옴표 상관없이 사용 가능! -->
	- s3에 담긴 값이 "힘내!!"라는 값과 일치하는가? <b>${ s3 == '힘내!!' } 또는 ${ s3 eq "힘내!!" }</b> <br>
	<hr>
	
	<h3>* 객체가 null 체크, 리스트가 비어있는지 체크</h3>
	p1이 null인가? ${ p1 == null } 또는 ${ p1 eq null } <br>
	p2이 null인가? ${ p2 == null } 또는 ${ p2 eq null } 또는 ${ empty p2 }<br>
	
	l1이 비어있는가? ${ empty l1 } <br>
	l2가 비어있는가? ${ empty l2 } <br>
	l2가 비어있지 않은가? ${ not empty l2 } <br>
	<br>
	
	<h3>* 논리연산자</h3> 
	- true && true : ${ true && true } 또는 ${ true and true } <br>
	- true || false : ${ true || false } 또는 ${ true or false } <br>
	
	+ big이 small 보다 크고 l1이 비어있는가? <br>
	${ (big > small) && (empty l1) } <br>
	${ (big gt small) and (empty l1) } <br>
	
	
</body>
</html>