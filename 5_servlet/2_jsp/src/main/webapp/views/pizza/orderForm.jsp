<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

    <style>
        
    </style>
</head>
<body>
    <h1> &gt;.&lt; 피자 주문서 &gt;.&lt; </h1>

    <h3>현재 날짜</h3>
    <div id="date"></div>
    <br>

    <form action="/2_jsp/orderRequest.or" method="post">
        <fieldset id="userData">
            <legend>주문자 정보</legend>
            <div>
                이름 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="text" id="userName" name="userName" required>
            </div>
            <div>
                연락처 &nbsp;&nbsp;
                <input type="tel" id="userTel" name="userTel" required>
            </div>
            <div>
                주소 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="text" id="address" name="address" required>
            </div>
            <div>
                요청사항 
                <textarea id="request" name="ask"></textarea>
            </div>
        </fieldset>

        <fieldset>
            <legend>주문 정보</legend>
            <div>
                피자 선택 <br>
                <select id="pizza" name="pizza" >
                    <option value="cheeze">치즈</option>
                    <option value="combination">콤비네이션</option>
                    <option value="bulgogi">불고기</option>
                    <option value="peperoni">페퍼로니</option>
                    <option value="hotchicken">핫치킨</option>
                </select>
            </div>
            <br>
            <div>
                토핑 <br>
                <input type="checkbox" name="topping" value="치즈">치즈 추가
                <input type="checkbox" name="topping" value="불고기">불고기 추가
                <input type="checkbox" name="topping" value="파인애플">파인애플 추가
                <input type="checkbox" name="topping" value="베이컨">베이컨 추가
                <input type="checkbox" name="topping" value="포테이토">포테이토
            </div>
            <br>
            <div>
                엣지 선택 <br>
                <input type="radio" name="edge" value="기본" checked>기본
                <input type="radio" name="edge" value="치즈크러스트">치즈 크러스트
                <input type="radio" name="edge" value="고구마크러스트">고구마 크러스트
                <input type="radio" name="edge" value="크러스트반반">치즈 고구마 반반
            </div>
            <br>
            <div>
                도우 선택 <br>
                <input type="radio" name="dow" value="기본" checked>기본
                <input type="radio" name="dow" value="씬">씬도우
                <input type="radio" name="dow" value="두껍게">두껍게
            </div>
            <br>
            <div>
                사이드 <br>
                <input type="checkbox" name="side" value="치즈오븐 토마토 파스타">치즈오븐 토마토 파스타
                <input type="checkbox" name="side" value="치즈오븐 까르보나라">치즈오븐 까르보나라
                <input type="checkbox" name="side" value="치킨텐더">치킨텐더
                <input type="checkbox" name="side" value="그릴드 윙,봉">그릴드 윙,봉
            </div>
            <br>
            <div>
                음료선택 <br>
                <input type="checkbox" name="beverage" value="코카콜라">코카콜라
                <input type="checkbox" name="beverage" value="제로콜라">제로콜라
                <input type="checkbox" name="beverage" value="사이다">사이다
                <input type="checkbox" name="beverage" value="제로사이다">제로사이다 <br>
                <input type="checkbox" name="beverage" value="레몬에이드">레몬에이드
                <input type="checkbox" name="beverage" value="자몽에이드">자몽에이드
                <input type="checkbox" name="beverage" value="아이스 아메리카노">아이스 아메리카노
            </div>
        </fieldset>
        <button>주문하기</button>
    </form>
</body>
<script type="text/javascript">
    onload = function() {
        setInterval(function() {
                const now = new Date();

                let month = now.getMonth()+1;
                let day = now.getDate();
                let hour = now.getHours();
                let min = now.getMinutes();
                let sec = now.getSeconds();

                document.getElementById("date").innerHTML = `${month}월 ${day}일 ${hour}:${min}:${sec}`;
            }, 1*1000);
    }
</script>
</html>