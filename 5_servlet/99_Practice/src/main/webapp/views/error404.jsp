<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error Page</title>
 <style>
     
       .wrap {
        height: 100vh;
        
        display: flex;
        flex-direction:column;
        justify-content: center;
        align-items: center;
       }

       #icon-emark {
        border: 2px solid red;
        border-radius: 50%;

        padding: 10px;
        width: 30px;
        height: 30px;

        text-align: center;
        line-height: 30px;

        color: red;
        font-weight: 900;
        font-size: 25px;

        text-shadow: 0px 0px 20px;
        box-shadow: 0px 0px 15px;
       }

       #btn-back {
        border: none;
        width: 200px;
        border-radius: 10px;

        background-color: #000;
        color: #fff;

        padding: 10px;
        margin: 10px;

        cursor: pointer;
       }
    </style>
</head>
<body>
    <div class="wrap">
       
        <span id="icon-emark">!</span>
        
        <h3>죄송합니다. 페이지를 찾을 수 없습니다.</h3>

        <p>잘못된 접근입니다. 다시 시도해주세요<p>
        
        <button id="btn-back" onclick="history.back()">이전으로</button>

    </div>
    
</body>
</html>