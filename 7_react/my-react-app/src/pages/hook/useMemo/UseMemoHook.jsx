import { useState } from "react";
import Title from "../../../components/Title";
import MemoView from "./MemoView";

const UseMemoHook = () => {
    const [num, setNum] = useState(0);
    const [text, setText] = useState('');

    const increase = () => {
        setNum(num + 1);
    }

    const decrease = () => {
        setNum(num - 1);
    }

    const changeText = (e) => { setText(e.target.value);}
    return (
        <>
            <Title text="useMemo"/>
            <div>
                <div>
                    <button onClick={increase}>+</button>&nbsp;
                    <button onClick={decrease}>-</button><br/>
                    <input type="text" onChange={changeText}></input>

                    <MemoView num={num} text={text} />
                </div>
            </div>
        </>
    )
}
export default UseMemoHook;