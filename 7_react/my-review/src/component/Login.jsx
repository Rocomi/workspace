import { createContext, useContext, useState } from "react";
import { UserContext } from "../App";

export const ResultContext = createContext();

function LoginPage () {

    const [id,setId] = useState('')
    const[pwd, setPwd] = useState('')

    const userCtx = useContext(UserContext);

    const handlerLogin = () => {
        userCtx.setData({id: id, pwd: pwd});
        // userCtx.setData => setUser
        // 입력된 id, password를 context에 저장
    }
    

    return(
        
        <div>
            <input type="text" class="userInput" value={id} onChange={(e)=>setId(e.target.value)}/> <br/>
            <input type="password" class="userInput" value={pwd} onChange={(e)=>setPwd(e.target.value)}/> <br/>
            <button type="button" class="loginButton" onClick={handlerLogin}>로그인</button>
        </div>

    )
}

export default LoginPage;