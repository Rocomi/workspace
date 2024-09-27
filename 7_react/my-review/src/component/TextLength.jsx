import { useRef, useState } from "react";
import styled from "styled-components";

const TextLengthArea = styled.div`
    display:flex;
    flex-direction: column;
    align-items: center;
    width: 100%;
`

const TextArea = styled.textarea`
    height: 100%;
    width: 600px;
    resize: none;
    font-size: x-large;
`

const TextLengthCount = styled.div`
    border: 1px solid #333;
    width: 100%;
    text-align:center;
`

function TextLength() {
    const [text, setText] = useState('');

    const taRef = useRef();

    function Clear() {
        setText('');

        taRef.current.focus();
    }

    return (
        <TextLengthArea>
            <TextArea value={text} ref={taRef} onChange={(e)=> setText(e.target.value)}></TextArea>
            <TextLengthCount>
                <p>공백 포함 {text.length}자</p>
                <p>공백 제외 {text.replaceAll(' ','').length}자</p>
            </TextLengthCount>
            <button type="button" onClick={Clear}>초기화</button>
        </TextLengthArea>
    )
} 
export default TextLength;