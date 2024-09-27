<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>스크립팅 원소</h1>

    <!-- HTML 주석 : 브라우전의 개발자 도구 탭에서 노출됨 -->
    <%-- JPS 주석 : 브라우저의 개발자 도구 탭에서 노출되지 않음 --%> <br>

    <%  // 스크립트릿 : 해당 영역에서는 일반적인 자바코드 작성 <br>
        //              (변수 선언, 초기화, 제어문 등) <br>

        int sum = 0;
        for(int i=0; i<=100; i++) {
            sum += i;
        }
    %>

    <p>
        화면에 출력 <br>
        표현식을 사용하여 출력 : <%= sum %> <br>
        스크립트릿을 사용하여 출력 : <% out.println(sum); %> <br>
        <%-- out : JSP 내장객체 (PrintWriter타입) --%>
    </p>

    <%
        String[] pArr = {"기다운", "양준혁", "임현호", "조건웅"};
    %>

    <h5>배열 길이 : <% out.println(pArr.length); %></h5>
    <h5>배열에 담긴 값 : <% out.println(String.join(",",pArr)); %></h5>
    <h5>반복문 사용하여 출력 : </h5>
    <ul>
        <% for(String p : pArr) { %>
               <li><%= p %></li>
            <% } %>
        
    </ul>

</body>
</html>