/**
 * 
 */
const CLIENT_ID = "1032651906538-p5fjptu5u00t4jqq44pfr7p1i8e5h17d.apps.googleusercontent.com";
const REDIRECT_URI = "http://localhost:7777/login/oauth/google";
//onload 시점에 이벤트 핸들러 추가
window.onload = () => {

    // btn-google이라는 아이디 속성을 가진 요소의 클릭 이벤트
    document.getElementById("btn-google").onclick = () => {
        // alert("구글 로그인!@");
        const url ="https://accounts.google.com/o/oauth2/v2/auth"
                    + "?client_id=" + CLIENT_ID
                    + "&redirect_uri=" + REDIRECT_URI
                    + "&response_type=code"
                    + "&scope=email profile";

        location.href = url;
    }

}