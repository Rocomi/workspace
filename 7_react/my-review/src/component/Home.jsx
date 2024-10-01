import { useContext } from "react";
import Login from "./Login";
import { UserContext } from "../App";


const Home = () => {
    const userCtx = useContext(UserContext);
    const user = userCtx.data;      // userCtx.data => user

    return (
        <>
            {   
                user.id === '' ?
                    <Login />
                :
                    <div>
                        <h3>{user.id}님 반갑습니다.</h3>
                        <input type='button' class="loginButton" value='로그아웃' onClick={()=>{userCtx.setData({id: '', pwd: ''})}}/>
                    </div>
            }
            
        </>
    )
}

export default Home;